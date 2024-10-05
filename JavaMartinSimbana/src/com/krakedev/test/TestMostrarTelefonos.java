package com.krakedev.test;

import com.krakedev.evaluacion.Contacto;
import com.krakedev.evaluacion.Direccion;
import com.krakedev.evaluacion.Telefono;

public class TestMostrarTelefonos {
	public static void main(String[] args) {
		 // Crear una instancia de Direccion
	    Direccion direccion = new Direccion("Calle Principal", "Calle Secundaria");

	    // Crear una instancia de Contacto
	    Contacto contacto = new Contacto("1234567890", "Juan", "Pérez");
	    contacto.setDireccion(direccion);

	    // Crear instancias de Teléfono
	    Telefono telefono1 = new Telefono("134567890", "Movil");
	    Telefono telefono2 = new Telefono("9876543210", "Movil");
	    Telefono telefono3 = new Telefono("1112233", "Convencional");

	    // Agregar teléfonos al contacto
	    contacto.agregarTelefono(telefono1);
	    contacto.agregarTelefono(telefono2);
	    contacto.agregarTelefono(telefono3);

	    // Mostrar información del contacto
	   
	    

	    // Mostrar teléfonos con estado "C"
	    contacto.mostrarTelefonos();
	}
}
   


