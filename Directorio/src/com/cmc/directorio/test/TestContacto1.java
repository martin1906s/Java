package com.cmc.directorio.test;

import com.cmc.directorio.entidades.Contacto;
import com.cmc.directorio.entidades.Telefono;

public class TestContacto1 {

	public static void main(String[] args) {
		Telefono telf=new Telefono("Movi", "0912345678", 234);
		Contacto c=new Contacto("Martín", "Simbaña", telf, 75);
		c.imprimir();
	}

}
