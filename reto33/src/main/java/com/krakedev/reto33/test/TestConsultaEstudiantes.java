package com.krakedev.reto33.test;

import java.util.ArrayList;

import com.krakedev.preto33.servicios.AdminEstudiantes;
import com.krakedev.reto33.entidades.Estudiante;

public class TestConsultaEstudiantes {

	public static void main(String[] args) {
		try {
			ArrayList<Estudiante> e=AdminEstudiantes.buscarPorNombre("Ma");
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
