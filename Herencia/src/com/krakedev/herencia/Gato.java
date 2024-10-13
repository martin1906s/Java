package com.krakedev.herencia;

public class Gato extends Animal {
	@Override
	public void dormir() {
		System.out.println("el gato de durmió :)");
	}
	
	public void maullar() {
		System.out.println("Gato maullando");
	}
	//Sobrecarga
	public void maullar(String adjetivo) {
		System.out.println("Gato maullando "+adjetivo);
	} 
}
 