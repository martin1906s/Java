package com.krakedev.test;

import com.krakedev.evaluacion.Contacto;
import com.krakedev.evaluacion.Direccion;
import com.krakedev.evaluacion.Directorio;
import com.krakedev.evaluacion.Telefono;

public class TestContarFijos {
	 public static void main(String[] args) {
	        // Crear un directorio
	        Directorio directorio = new Directorio();

	        // Agregar contactos con teléfonos convencionales en estado "C"
	        Contacto contacto1 = new Contacto("1234567890", "Juan", "Pérez");
	        Direccion direccion1 = new Direccion("Calle A", "Calle B");
	        contacto1.setDireccion(direccion1);
	        contacto1.agregarTelefono(new Telefono("9876549", "Convencional"));
	        directorio.agregarContacto(contacto1);

	        Contacto contacto2 = new Contacto("9876543210", "Ana", "Gómez");
	        Direccion direccion2 = new Direccion("Calle X", "Calle Y");
	        contacto2.setDireccion(direccion2);
	        contacto2.agregarTelefono(new Telefono("9876543218", "Movil"));
	        directorio.agregarContacto(contacto2);

	        // Agregar contactos sin teléfonos convencionales o en estado "C"
	        Contacto contacto3 = new Contacto("1112233445", "Carlos", "Ruiz");
	        Direccion direccion3 = new Direccion("Calle Z", "Calle W");
	        contacto3.setDireccion(direccion3);
	        contacto3.agregarTelefono(new Telefono("9876349", "Convencional"));
	        directorio.agregarContacto(contacto3);

	        // Contar contactos con teléfonos convencionales y estado "C" y mostrar el resultado
	        int fijos = directorio.contarFijos();
	        System.out.println("Fijos: " + fijos);
	    }
}
