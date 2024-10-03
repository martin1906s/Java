package com.clearminds.test;

import com.clearminds.componentes.Celda;
import com.clearminds.maquina.MaquinaDulces;

public class TestBusqueda {

	public static void main(String[] args) {
		MaquinaDulces maquina=new MaquinaDulces();
		maquina.configurarMaquina("A1", "A2", "B1", "B2");
		Celda celda=maquina.buscarCelda("A2");
		System.out.println("Celda Encontrada: "+celda.getCodigo());
		Celda celda2=maquina.buscarCelda("A3");
		if(celda2==null){
			System.out.println("no existe la celda");
		}
	}

}
