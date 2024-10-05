package com.krakedev.test;

import com.krakedev.evaluacion.Contacto;
import com.krakedev.evaluacion.Direccion;
import com.krakedev.evaluacion.Directorio;

public class TestAgregarContacto {
	public static void main(String[] args) {
        // Crear un directorio
        Directorio directorio = new Directorio();

        // Crear un contacto
        Contacto contacto1 = new Contacto("1234567890", "Juan", "Pérez");
        Direccion direccion1 = new Direccion("Calle A", "Calle B");
        contacto1.setDireccion(direccion1);
        boolean resultado1 = directorio.agregarContacto(contacto1);

        // Intentar agregar un segundo contacto con la misma cédula
        Contacto contacto2 = new Contacto("1234567890", "Ana", "Gómez" );
        Direccion direccion2 = new Direccion("Calle X", "Calle Y");
        contacto2.setDireccion(direccion2);
        boolean resultado2 = directorio.agregarContacto(contacto2);

        
        Contacto contacto3 = new Contacto("1234567891", "Ana", "Gómez");
        Direccion direccion3 =new Direccion("Calle X", "Calle Y");
        contacto3.setDireccion(direccion3);
        boolean resultado3 = directorio.agregarContacto(contacto3);
        
        Contacto contacto4 = new Contacto("1234567811", "Ana", "Gómez");
        Direccion direccion4 = new Direccion("Calle X", "Calle Y");
        contacto4.setDireccion(direccion4);
        boolean resultado4 = directorio.agregarContacto(contacto4);
        
        // Mostrar resultados
        System.out.println("Resultado al agregar contacto1: " + resultado1);
        System.out.println("Resultado al intentar agregar contacto2: " + resultado2);
        System.out.println("Resultado al intentar agregar contacto3: " + resultado3);
        System.out.println("Resultado al intentar agregar contacto3: " + resultado4);
        // Mostrar la información del directorio
    
    }
}
