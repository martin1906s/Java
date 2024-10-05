package com.krakedev.test;

import com.krakedev.evaluacion.Contacto;
import com.krakedev.evaluacion.Direccion;
import com.krakedev.evaluacion.Directorio;

public class TestUltimaModificacion {
	 public static void main(String[] args) {
	        // Crear un directorio
	        Directorio directorio = new Directorio();

	        // Agregar un contacto
	        Contacto contacto = new Contacto("1234567890", "Juan", "Pérez");
	        Direccion direccion1 = new Direccion("Calle A", "Calle B");
	        contacto.setDireccion(direccion1);
	        directorio.agregarContacto(contacto);

	        // Consultar la última modificación y mostrar el resultado
	        String ultimaModificacion = directorio.consultarUltimaModificacion();
	        System.out.println("Última modificación: " + ultimaModificacion);
	    }
}
