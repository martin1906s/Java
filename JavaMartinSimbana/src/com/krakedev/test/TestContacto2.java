package com.krakedev.test;

import com.krakedev.evaluacion.Contacto;
import com.krakedev.evaluacion.Direccion;

public class TestContacto2 {

	public static void main(String[] args) {
		
		// Crear una instancia de Contacto
        Contacto contacto = new Contacto("1234567890", "Rosa", "Chavez");

        // Settear la dirección
        Direccion Direccion = new Direccion("Av. Siempre Viva", "Calle 4");
        contacto.setDireccion(Direccion);
        
     // Crear una instancia de Contacto sin direccion
        Contacto contacto2 = new Contacto("1234567890", "Ernesto", "Montoya");
        
        // Mostrar información 
        
        contacto.imprimir();
        contacto2.imprimir();
    }
}


