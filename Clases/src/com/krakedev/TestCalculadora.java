package com.krakedev;

public class TestCalculadora {

	public static void main(String[] args) {
		Calculadora calcu=new Calculadora();
		int resultadoSuma;
		double resultadoResta;
		resultadoSuma=calcu.sumar(5, 3);
		resultadoResta=calcu.restar(10, 3);
		System.out.println("Resultado Suma: "+ resultadoSuma);
		System.out.println("Resultado Resta: "+ resultadoResta);
	}

}
