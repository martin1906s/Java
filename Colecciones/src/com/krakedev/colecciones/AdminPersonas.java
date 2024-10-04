package com.krakedev.colecciones;

import java.util.ArrayList;

public class AdminPersonas {
	private ArrayList<Persona> personas;

	public AdminPersonas() {
		personas = new ArrayList<Persona>();
	}

	public void agregar(Persona persona) {
		personas.add(persona);
	}

	public void imprimir() {
		Persona persona;
		for (int i = 0; i < personas.size(); i++) {
			persona = personas.get(i);
			System.out.println(persona.getNombre() + " " + persona.getApellido() + ", " + persona.getEdad() + " años");
		}
	}
	
	public Persona buscarPorNombre(String nombre) {
		Persona personaEncontrada=null;
		Persona elementoPersona=null;

		for(int i=0;i<personas.size();i++) {
			elementoPersona=personas.get(i);
			if(nombre.equals(elementoPersona.getNombre())) {
				personaEncontrada=elementoPersona;
			}
		}
		
		return personaEncontrada;
	}
	
	public ArrayList<Persona> buscarMayor(int edad){
		ArrayList<Persona> mayores=new ArrayList<Persona>();
		Persona elementoPersona=null;
		for(int i=0;i<personas.size();i++) {
			elementoPersona=personas.get(i);
			if(elementoPersona.getEdad()>edad) {
				mayores.add(elementoPersona);
				System.out.println("Persona Mayor: "+elementoPersona.getNombre()+" "+elementoPersona.getApellido());
				
			}
			
		}
		return mayores;
	}
}
