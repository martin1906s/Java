package com.cmc.evaluacion.servicios;

import java.util.ArrayList;

import com.cmc.evaluacion.entidades.Cliente;
import com.cmc.evaluacion.entidades.Prestamo;

public class Banco {
	ArrayList<Prestamo> prestamos;
	ArrayList<Cliente> clientes;

	public Banco() {
		this.prestamos = new ArrayList<>();
		this.clientes = new ArrayList<>();
	}

	public ArrayList<Prestamo> getPrestamos() {
		return prestamos;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public Cliente buscarCliente(String cedula) {
		Cliente clienteEncontrado;
		for (int i = 0; i < clientes.size(); i++) {
			clienteEncontrado = clientes.get(i);
			if (clienteEncontrado.getCedula().equals(cedula)) {
				return clienteEncontrado;
			}

		}
		return null;
	}

	public void registrarCliente(Cliente cliente) {
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getCedula().equals(cliente.getCedula())) {
				System.out.println("Cliente ya existe: " + cliente.getCedula());
				return;
			}
		}
		clientes.add(cliente);

	}

	public void asignarPrestamo(String cedula, Prestamo prestamo) {
		Cliente clienteBuscado = buscarCliente(cedula);
		if (clienteBuscado == null) {
			System.out.println("NO es cliente del banco");
			return;
		} else {
			prestamos.add(prestamo);
		}
	}

	public ArrayList<Prestamo> buscarPrestamos(String cedula) {
		ArrayList<Prestamo> prestamosCliente = new ArrayList<>();
		Cliente cliente = buscarCliente(cedula);
		if (cliente == null) {
			System.out.println("No es cliente del banco");
			return null;
		}
		for (int i = 0; i < prestamos.size(); i++) {
			prestamosCliente.add(prestamos.get(i));
		}
		if (prestamosCliente.size() > 0) {
			return prestamosCliente;
		} else {
			return null;
		}
	}

}
