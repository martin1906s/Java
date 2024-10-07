package test;

import entidades.Carta;
import entidades.Naipe;

public class testNaipe {

	public static void main(String[] args) {
		
		  Naipe naipe = new Naipe();

	        
	        for (Carta carta : naipe.getCartas()) {
	        	 carta.mostrarInfo(); 
	        }
	}

}
