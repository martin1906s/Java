package com.krakedev;

public class TestCuadrados {

	public static void main(String[] args) {
		Cuadrado c1=new Cuadrado();
		Cuadrado c2=new Cuadrado();
		Cuadrado c3=new Cuadrado();
		c1.lado=25;
		c2.lado=12.3;
		c3.lado=19.20;
		double areaC1=c1.calcularArea();
		double perimetroC1=c1.calcularPerimetro();
		
		double areaC2=c2.calcularArea();
		double perimetroC2=c2.calcularPerimetro();
		
		double areaC3=c3.calcularArea();
		double perimetroC3=c3.calcularPerimetro();
		
		System.out.println("Area Cuadrado1: "+areaC1);
		System.out.println("Perimetro Cuadrado1: "+perimetroC1);
		System.out.println("Area Cuadrado2: "+areaC2);
		System.out.println("Perimetro Cuadrado2: "+perimetroC2);
		System.out.println("Area Cuadrado3: "+areaC3);
		System.out.println("Perimetro Cuadrado3: "+perimetroC3);

	}

}
