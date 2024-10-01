package com.cmc.directorio.entidades;

public class AdminContactos {
	public Contacto buscarMasPesado(Contacto c1, Contacto c2) {
		System.out.println("El más pesado es:");
		if(c1.getPeso()>c2.getPeso()) {
			return c1;
		}else {
			return c2;
		}
	}
	
	public boolean compararOperadoras(Contacto c1, Contacto c2) {
		if(c1.getTelefono().getOperadora()==c2.getTelefono().getOperadora()) {
			System.out.println("Ambos tienen operadoras "+c1.getTelefono().getOperadora()+" asi que es");
			return true;
		}else {
			System.out.println("Los dos tienen diferentes operadoras asi que es");
			return false;
		}
	}
	
	public void activarUsuario(Contacto c1) {
		if(c1.getTelefono().isTieneWhatsapp()==true) {
			c1.setActivo(true);
		}else {
			c1.setActivo(false);
		}
	}
}
