package com.cmc.repaso.test;

import com.cmc.repaso.entidades.Estudiante;

public class TestEstudiante {

	public static void main(String[] args) {
		Estudiante estudiante1=new Estudiante("Mayté");
		Estudiante estudiante2=new Estudiante("Martín");
		Estudiante estudiante3=new Estudiante("Mathias");
		
		estudiante1.calificar(10);
		estudiante2.calificar(6);
		estudiante3.calificar(-1);
		
		System.out.println(estudiante1.getNombre()+" su resultado es '"+estudiante1.getResultado()+"'");
		System.out.println(estudiante2.getNombre()+" su resultado es '"+estudiante2.getResultado()+"'");
		System.out.println(estudiante3.getNombre()+" su resultado es '"+estudiante3.getResultado()+"'");


		
	}

}
