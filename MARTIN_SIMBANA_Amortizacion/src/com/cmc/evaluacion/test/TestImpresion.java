package com.cmc.evaluacion.test;

import com.cmc.evaluacion.entidades.Cuota;

public class TestImpresion {
	public static void main(String[] args) {

	Cuota cuota = new Cuota(1);
	cuota.setCuota(44.24);
	cuota.setInicio(5000);
	cuota.setInteres(50);
	cuota.setAbonoCapital(394.24134);
	cuota.setSaldo(4605.76);
	
	cuota.mostrarPrestamo();
	}
}
