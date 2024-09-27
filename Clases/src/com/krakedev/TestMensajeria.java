package com.krakedev;

public class TestMensajeria {

	public static void main(String[] args) {
		Mensajeria m=new Mensajeria();
		m.getSaludar();
		m.setNombre("Pepe");
		m.setApellido("Pancho");
		System.out.println("Hola "+m.getNombre()+" "+m.getApellido());
	}

}
