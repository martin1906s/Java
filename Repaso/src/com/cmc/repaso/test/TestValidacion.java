package com.cmc.repaso.test;

import com.cmc.repaso.entidades.Validacion;

public class TestValidacion {

	public static void main(String[] args) {
		Validacion monto=new Validacion();
		
		System.out.println(monto.validarMonto(100));
		System.out.println(monto.validarMonto(-1));
		System.out.println(monto.validarMonto(0));

	}

}
