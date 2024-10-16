package com.krakedev.excepciones;

public class Ejercicio1 {
	public static void main(String[] args) {
		String a="s";
		try {
			a.charAt(0);
			System.out.println("Fin");

		}catch(Exception ex) {
			System.out.println("Entra al catch");
		}finally {
			System.out.println("Entra a finally");
		}
	}
}
