package com.clearminds.test;

import com.clearminds.componentes.Celda;
import com.clearminds.componentes.Producto;
import com.clearminds.maquina.MaquinaDulces;

public class TestBuscarMenores {

    public static void main(String[] args) {
        MaquinaDulces maquina = new MaquinaDulces();

        Producto producto1 = new Producto("P001", "Papitas", 0.85);
        Producto producto2 = new Producto("D001", "Doritos", 0.5);
        Producto producto3 = new Producto("J001", "Jet", 0.25);
        Producto producto4 = new Producto("DT001", "DeTodito", 0.6);
        Producto producto5 = new Producto("C001", "Gomitas", 1.0);
        Producto producto6 = new Producto("G001", "Galletas", 0.95);

        maquina.agregarCelda(new Celda("A1"));
        maquina.agregarCelda(new Celda("A2"));
        maquina.agregarCelda(new Celda("B1"));
        maquina.agregarCelda(new Celda("B2"));
        maquina.agregarCelda(new Celda("C1"));
        maquina.agregarCelda(new Celda("C2"));

        maquina.cargarProducto(producto1, "A1", 4);
        maquina.cargarProducto(producto2, "A2", 3);
        maquina.cargarProducto(producto3, "B1", 5);
        maquina.cargarProducto(producto4, "B2", 2);
        maquina.cargarProducto(producto5, "C1", 1);
        maquina.cargarProducto(producto6, "C2", 0);

        maquina.buscarMenores(4);
    }
}

