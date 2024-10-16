package com.krakedev.reto33.test;

import com.krakedev.preto33.servicios.AdminEstudiantes;
import com.krakedev.reto33.entidades.Estudiante;

public class TestConsultaPK {

	public static void main(String[] args) {
		try {
			Estudiante e=AdminEstudiantes.buscarPorPK("6677889900");
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
