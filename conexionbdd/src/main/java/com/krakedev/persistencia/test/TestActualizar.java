package com.krakedev.persistencia.test;

import com.krakedev.persistencia.entidades.Persona;
import com.krakedev.persistencia.entidades.Prestamo;
import com.krakedev.persistencia.servicios.AdminPersonas;
import com.krakedev.persistencia.utils.Convertidor;

public class TestActualizar {

	public static void main(String[] args) throws Exception {
		Prestamo pres=new Prestamo("1751013192", "Abigail Herrera"); 
		Persona p=new Persona(pres, "Martin", "Simbaña", Convertidor.convertirFecha("1945/06/19"));

		
		try {
			AdminPersonas.actualizar(p);
			System.out.println("Actualizado");
		}catch(Exception e) {
			
		}
	}

}
