package com.krakedev;

public class TestFecha {

	public static void main(String[] args) {
		Fecha fecha1=new Fecha();
		fecha1.setAnio(2000);
		fecha1.setMes(12);
		fecha1.setDia(24);
		System.out.println(fecha1.getAnio());
		System.out.println(fecha1.getMes());
		System.out.println(fecha1.getDia());
	}

}
