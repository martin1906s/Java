package com.krakedev.estaticos;

public class Calculos {
	/*final hace el valor constante. 
	 * No se cambia en ningun momento su valor
	 * Y la variable va todo en mayusculas para diferenciarlo*/ 
	private final double IVA=12;
	public double calcularIva(double monto) {
		return monto*IVA/100;
	}
}
