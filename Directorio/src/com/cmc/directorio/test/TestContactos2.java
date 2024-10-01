package com.cmc.directorio.test;

import com.cmc.directorio.entidades.AdminContactos;
import com.cmc.directorio.entidades.Contacto;
import com.cmc.directorio.entidades.Telefono;

public class TestContactos2 {

	public static void main(String[] args) {
		Telefono telf1=new Telefono("Movi", "0912345678", 234);
		Telefono telf2=new Telefono("Claro", "0987654321", 235);
		Contacto c1=new Contacto("Abigail", "Herrera", telf1, 60);
		Contacto c2=new Contacto("Martín","Simbaña",telf2,75); 
		AdminContactos acts=new AdminContactos();
		Contacto masPesado=acts.buscarMasPesado(c1, c2);
		masPesado.imprimir();
		boolean op=acts.compararOperadoras(c1, c2);
		System.out.println(op);
	}

}
