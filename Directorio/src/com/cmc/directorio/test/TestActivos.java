package com.cmc.directorio.test;

import com.cmc.directorio.entidades.AdminContactos;
import com.cmc.directorio.entidades.Contacto;
import com.cmc.directorio.entidades.Telefono;

public class TestActivos {

	public static void main(String[] args) {
		Telefono telf1= new Telefono("Movi", "0998733975", 580);
		Contacto c1=new Contacto("Alexandra", "Flores", telf1, 83);
		c1.imprimir();
		AdminContactos ad=new AdminContactos();
		ad.activarUsuario(c1);
		c1.imprimir();
	}

}
