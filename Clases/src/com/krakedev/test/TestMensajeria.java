package com.krakedev.test;

import com.krakedev.Mensajeria;

public class TestMensajeria {

	public static void main(String[] args) {
		Mensajeria m=new Mensajeria("Martín");
		m.getSaludar();
		m.setApellido("Pancho");
		System.out.println("Hola "+m.getNombre()+" "+m.getApellido());
	}

}
