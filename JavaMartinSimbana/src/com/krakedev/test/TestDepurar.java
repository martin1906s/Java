package com.krakedev.test;

import com.krakedev.evaluacion.Contacto;
import com.krakedev.evaluacion.Direccion;
import com.krakedev.evaluacion.Directorio;

public class TestDepurar {
	  public static void main(String[] args) {
	        // Crear un directorio
	        Directorio directorio = new Directorio();

	        // Agregar contactos con y sin dirección
	        Contacto contacto1 = new Contacto("1234567890", "Juan", "Pérez");
	        Direccion direccion1 = new Direccion("Calle A", "Calle B");
	        contacto1.setDireccion(direccion1);
	        directorio.agregarContacto(contacto1);

	        Contacto contacto2 = new Contacto("9876543210", "Ana", "Gómez");
	        directorio.agregarContacto(contacto2);

	        Contacto contacto3 = new Contacto("1112233445", "Carlos", "Ruiz");
	        Direccion direccion3 = new Direccion("Calle X", "Calle Y");
	        contacto3.setDireccion(direccion3);
	        directorio.agregarContacto(contacto3);

	        // Depurar los contactos
	        directorio.depurar();

	        // Mostrar los resultados
	        int correctos=0;
	        for (int i = 0; i < directorio.getCorrectos().size(); i++) {
	        	correctos=correctos+1;
			}
	        
	        System.out.println("Correctos:"+correctos);
	 	     
	        int incorrectos=0;
	        for (int i = 0; i < directorio.getIncorrectos().size(); i++) {
	        	incorrectos=incorrectos+1;
			}
	        System.out.println("Incorrectos:"+incorrectos);
	        
	        int totalContactos=0;
	        for (int i = 0; i < directorio.getContactos().size(); i++) {
	        	totalContactos=totalContactos+1;
			}
	        
	        System.out.println("Contactos:"+totalContactos);
	    }
	  
	  
	  
}
