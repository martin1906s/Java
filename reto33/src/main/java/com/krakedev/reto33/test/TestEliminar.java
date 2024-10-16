package com.krakedev.reto33.test;

import com.krakedev.preto33.servicios.AdminEstudiantes;

public class TestEliminar {

	public static void main(String[] args) throws Exception {
		try {
			AdminEstudiantes.eliminar("1751013192");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
