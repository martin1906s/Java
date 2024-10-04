package com.krakedev.colecciones;

import java.util.ArrayList;

public class Ejercicio2 {

	public static void main(String[] args) {
		ArrayList<Persona> personas = new ArrayList<Persona>();
		personas.add(new Persona("Martín","Simbaña"));
		personas.add(new Persona("Abigail","Herrera"));
		personas.add(new Persona("Mayté","Simbaña"));
		
		Persona persona;
		for(int i=0;i<personas.size();i++) {
			persona=personas.get(i);
			System.out.println("Nombre: "+persona.getNombre()+"\nApellido: "+persona.getApellido());
		}

	}

}
