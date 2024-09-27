package com.krakedev;

public class TestCuadrados {

	public static void main(String[] args) {
		Cuadrado c1=new Cuadrado();
		Cuadrado c2=new Cuadrado();
		Cuadrado c3=new Cuadrado();
		c1.setArea(25);
		c1.setPerimetro(10);
		c2.setArea(30);
		c2.setPerimetro(15);
		c3.setArea(24);
		c3.setPerimetro(12);
		System.out.println("Area Cuadrado1: "+c1.getArea());
		
		System.out.println("Perimetro Cuadrado1: "+c1.getPerimetro());

		System.out.println("Area Cuadrado2: "+c2.getArea());
		
		System.out.println("Perimetro Cuadrado2: "+c2.getPerimetro());
		
		System.out.println("Area Cuadrado3: "+c3.getArea());
		
		System.out.println("Perimetro Cuadrado3: "+c3.getPerimetro());

	}

}
