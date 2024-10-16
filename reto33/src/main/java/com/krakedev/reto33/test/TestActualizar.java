package com.krakedev.reto33.test;

import com.krakedev.preto33.servicios.AdminEstudiantes;
import com.krakedev.reto33.entidades.Estudiante;
import com.krakedev.reto33.entidades.Profesor;
import com.krakedev.reto33.utils.Convertidor;

public class TestActualizar {

	public static void main(String[] args) throws Exception {
		Profesor prof=new Profesor(5, "Pedro"); 
		Estudiante p=new Estudiante("1751013192","Monica", "Benavises", "mayIsa123@gmail.com", Convertidor.convertirFecha("2012/12/18"), prof);


		
		try {
			AdminEstudiantes.actualizar(p);
			System.out.println("Actualizado");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
