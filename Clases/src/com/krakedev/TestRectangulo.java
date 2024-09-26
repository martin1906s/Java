package com.krakedev;

public class TestRectangulo {

	public static void main(String[] args) {
		Rectangulo r1=new Rectangulo();
		Rectangulo r2=new Rectangulo();
		int areaR2;
		int areaR1;
		double perimetroR1;
		double perimetroR2;
		r1.base=10;
		r1.altura=5;
		
		r2.base=8;
		r2.altura=3;
		
		areaR1=r1.calcularArea();
		perimetroR1=r1.calcularPerimetro();
		areaR2=r2.calcularArea();
		perimetroR2=r2.calcularPerimetro();
		System.out.println("Area r1: "+areaR1);
		System.out.println("Perimetro r1: "+perimetroR1);
		System.out.println("Area r2: "+areaR2);
		System.out.println("Perimetro r2: "+perimetroR2);	
	}

}
