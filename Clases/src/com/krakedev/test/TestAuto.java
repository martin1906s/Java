package com.krakedev.test;

import com.krakedev.Auto;

public class TestAuto {

	public static void main(String[] args) {
		Auto auto1=new Auto();
		Auto auto2=new Auto();
		
		auto1.setAnio(2016);
		auto1.setMarca("Chevrolet");
		auto1.setPrecio(16000.45);
		
		auto2.setAnio(2024);
		auto2.setMarca("Mazda");
		auto2.setPrecio(106000.45);
		System.out.println("__________AUTO1________");
		System.out.println("Marca: "+auto1.getMarca());
		System.out.println("Año: "+auto1.getAnio());
		System.out.println("Precio: "+auto1.getPrecio());
		System.out.println("_______AUTO2___________");
		System.out.println("Marca: "+auto2.getMarca());
		System.out.println("Año: "+auto2.getAnio());
		System.out.println("Precio: "+auto2.getPrecio());
	}

}
