package com.krakedev;

public class TestRectangulo {

	public static void main(String[] args) {
		Rectangulo r1=new Rectangulo();
		Rectangulo r2=new Rectangulo();
		
		r1.setArea(10, 5);
		r1.setPerimetro(10, 5);
		r2.setArea(8, 3);
		r2.setPerimetro(8, 3);
		System.out.println("Area r1: "+r1.getArea());
		System.out.println("Perimetro r1: "+r1.getPerimetro());
		System.out.println("Area r2: "+r2.getArea());
		System.out.println("Perimetro r2: "+r2.getPerimetro());	
	}

}
