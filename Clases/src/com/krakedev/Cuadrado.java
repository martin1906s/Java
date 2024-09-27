package com.krakedev;

public class Cuadrado {
	private double area;
	private double perimetro;
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
		this.area=this.area * this.area;
	}
	public double getPerimetro() {
		return perimetro;
	}
	public void setPerimetro(double perimetro) {
		this.perimetro = perimetro;
		this.perimetro=this.perimetro *4;
	}
	
	
}
