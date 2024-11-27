package com.krakedev.inventarios.entidades;

public class Categoria {
	private Integer codigo;
	private String nombre;
	private Categoria categoriaPadre;
	public Categoria() {}
	public Categoria(Integer codigo, String nombre, Categoria categoriaPadre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.categoriaPadre = categoriaPadre;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Categoria getCategoriaPadre() {
		return categoriaPadre;
	}
	public void setCategoriaPadre(Categoria categoriaPadre) {
		this.categoriaPadre = categoriaPadre;
	}
	@Override
	public String toString() {
		return "Categoria [codigo=" + codigo + ", nombre=" + nombre + ", categoriaPadre=" + categoriaPadre + "]";
	}
	
	
}
