package com.krakedev.evaluacion;

public class Telefono {
	private String numero;
	private String tipo;
	private String estado;

	public Telefono(String numero, String tipo) {
		this.numero = numero;
		this.tipo = tipo;
		if (numero == null || tipo == null) {
			this.estado = "E";
		} else {
			this.estado = "C";
			if (tipo.equals("Movil") || tipo.equals("Convencional")) {
				this.estado = "C";
				if ((tipo.equals("Movil") && numero.length() == 10)
						|| (tipo.equals("Convencional") && numero.length() == 7)) {
					this.estado = "C";
				} else {
					this.estado = "E";
				}
			} else {
				this.estado = "E";
			}
		}
	}

	public String getNumero() {
		return numero;
	}

	public String getTipo() {
		return tipo;
	}

	public String getEstado() {
		return estado;
	}

}
