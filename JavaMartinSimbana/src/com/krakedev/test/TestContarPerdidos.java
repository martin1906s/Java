package com.krakedev.test;

import com.krakedev.evaluacion.Contacto;
import com.krakedev.evaluacion.Direccion;
import com.krakedev.evaluacion.Directorio;

public class TestContarPerdidos {
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
	        directorio.agregarContacto(contacto3);

	        // Contar contactos sin dirección asignada y mostrar el resultado
	        int perdidos = directorio.contarPerdidos();
	        System.out.println("Sin Rumbo: " + perdidos);
	    }
}
