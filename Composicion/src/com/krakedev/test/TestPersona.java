package com.krakedev.test;

import com.krakedev.composicion.Direccion;
import com.krakedev.composicion.Persona;

public class TestPersona {

	public static void main(String[] args) {
		Persona p1=new Persona();
		p1.setNombre("Martín");
		p1.setApellido("Simbaña");
		
		
		String nombre=p1.getNombre();
		Direccion dir=new Direccion();
		dir.setCallePrincipal("Av Siempre Viva");
		dir.setCalleSecundaria("La que cruza");
		dir.setNumero("N65-98");
		p1.setDireccion(dir);
		Direccion d1=p1.getDireccion();
		System.out.println(nombre);
		System.out.println(d1.getCallePrincipal());
		Persona p2=new Persona();
		Direccion d2=new Direccion("Av Shyris", "Eloy Alfaro","S/N");
		p2.setNombre("Abi");
		p2.setDireccion(d2);
		p2.imprimir();
		
		p1.imprimir();
		Persona p3=new Persona();
		p3.setDireccion(new Direccion("XX","YY","123"));
		p3.imprimir();
	}

}
