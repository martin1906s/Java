package com.cmc.repaso.test;

import com.cmc.repaso.entidades.Item;

public class TestItem {

	public static void main(String[] args) {
		Item p1=new Item("Pantalon",20);
		Item p2=new Item("Camiseta",200);
		
		p1.vender(13);
		p1.imprimir();
		p1.devolver(4);
		p1.imprimir();
		
		p2.vender(50);
		p2.imprimir();
		p2.devolver(25);
		p2.imprimir();
	}

}
