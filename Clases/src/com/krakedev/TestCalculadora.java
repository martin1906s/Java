package com.krakedev;

public class TestCalculadora {

	public static void main(String[] args) {
		Calculadora calcu=new Calculadora();
		int resultadoSuma;
		double resultadoResta;
		resultadoSuma=calcu.sumar(5, 3);
		resultadoResta=calcu.restar(10, 3);
		
		double resultadoMultiplicar=calcu.multiplicar(10, 5);
		double resultadoDividir=calcu.dividr(10, 2);
		double resultadoPromedio=calcu.promediar(10, 8, 9);
		
		System.out.println("Resultado Suma: "+ resultadoSuma);
		System.out.println("Resultado Resta: "+ resultadoResta);
		System.out.println("Resultado Multiplicar: "+ resultadoMultiplicar);
		System.out.println("Resultado Dividir: "+ resultadoDividir);
		System.out.println("Resultado Promedio: "+ resultadoPromedio);
		calcu.mostrarResultado();
	}

}
