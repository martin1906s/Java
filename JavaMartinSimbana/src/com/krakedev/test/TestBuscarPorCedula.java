package com.krakedev.test;

import com.krakedev.evaluacion.Contacto;
import com.krakedev.evaluacion.Direccion;
import com.krakedev.evaluacion.Directorio;

public class TestBuscarPorCedula {
public static void main(String[] args) {
	  // Crear un directorio
    Directorio directorio = new Directorio();

    // Crear un contacto
    Contacto contacto = new Contacto("1234567890", "Juan", "Pérez");
    Direccion direccion1 = new Direccion("Calle A", "Calle B");
    contacto.setDireccion(direccion1);
    directorio.agregarContacto(contacto);
    Contacto contacto2 = new Contacto("1234567895", "Juan", "Pérez");
    Direccion direccion2 = new Direccion("Calle A", "Calle B");
    contacto2.setDireccion(direccion2);
    // Buscar el contacto por cédula
    String cedulaBuscada = "1234567890";
    Contacto resultadoBusqueda = directorio.buscarPorCedula(cedulaBuscada);

    // Mostrar el resultado de la búsqueda
    if (resultadoBusqueda != null) {
        System.out.println("Contacto encontrado:");
        resultadoBusqueda.imprimir();
    } else {
        System.out.println("Contacto con cédula " + cedulaBuscada + " no encontrado.");
    }
    
    String cedulaBuscada2 = "1234567895";
    Contacto resultadoBusqueda2 = directorio.buscarPorCedula(cedulaBuscada2);

    // Mostrar el resultado de la búsqueda
    if (resultadoBusqueda2 != null) {
        System.out.println("Contacto encontrado:");
        resultadoBusqueda.imprimir();
    } else {
        System.out.println("Contacto con cédula " + cedulaBuscada2 + " no encontrado.");
    }
}
}
