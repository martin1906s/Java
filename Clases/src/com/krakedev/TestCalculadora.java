package com.krakedev;

public class TestCalculadora {

	public static void main(String[] args) {
		Calculadora calcu=new Calculadora();
		calcu.setSuma(5,3);
		calcu.setResta(10, 3);
		calcu.setMultiplicar(10, 5);
		calcu.setDividir(10, 5);
		calcu.setPromediar(10, 8, 9);

		
		System.out.println("Resultado Suma: "+ calcu.getSuma());
		System.out.println("Resultado Resta: "+ calcu.getResta());
		System.out.println("Resultado Multiplicar: "+ calcu.getMultiplicar());
		System.out.println("Resultado Dividir: "+ calcu.getDividir());
		System.out.println("Resultado Promedio: "+ calcu.getPromediar());
		calcu.getMostrarResultado();
	}

}
