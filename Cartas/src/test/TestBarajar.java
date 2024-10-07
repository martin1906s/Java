package test;

import java.util.ArrayList;

import entidades.Carta;
import entidades.Naipe;

public class TestBarajar {

	public static void main(String[] args) {
		  Naipe naipe = new Naipe();
	        ArrayList<Carta> cartasBarajadas = naipe.barajar();

	       
	        for (Carta carta : cartasBarajadas) {
	            carta.mostrarInfo();
	        }

	}

}
