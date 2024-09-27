package com.krakedev;

public class Rectangulo {
	private int area;
	private int perimetro;
		
	public int getArea() {
		return area;
	}
	public void setArea(int base, int altura) {
		this.area = base*altura;
	}
	public int getPerimetro() {
		return perimetro;
	}
	public void setPerimetro(int base, int altura) {
		this.perimetro = (base*2)+(altura*2);
	}
}
