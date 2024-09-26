package com.krakedev;

public class TestAuto {

	public static void main(String[] args) {
		Auto auto1=new Auto();
		Auto auto2=new Auto();
		
		auto1.anio=2016;
		auto1.marca="Chevrolet";
		auto1.precio=16000.45;
		
		auto2.anio=2024;
		auto2.marca="Mazda";
		auto2.precio=6000.45;
		System.out.println("__________AUTO1________");
		System.out.println("Marca: "+auto1.marca);
		System.out.println("Año: "+auto1.anio);
		System.out.println("Precio: "+auto1.precio);
		System.out.println("_______AUTO2___________");
		System.out.println("Marca: "+auto2.marca);
		System.out.println("Año: "+auto2.anio);
		System.out.println("Precio: "+auto2.precio);
	}

}
