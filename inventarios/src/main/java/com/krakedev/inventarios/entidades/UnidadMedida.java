package com.krakedev.inventarios.entidades;

public class UnidadMedida {
	private String nombre;
	private String descripcion;
	private CategoriaUDM categoriaUDM;
	public UnidadMedida() {}
	public UnidadMedida(String nombre, String descripcion, CategoriaUDM categoriaUDM) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.categoriaUDM = categoriaUDM;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public CategoriaUDM getCategoriaUDM() {
		return categoriaUDM;
	}
	public void setCategoriaUDM(CategoriaUDM categoriaUDM) {
		this.categoriaUDM = categoriaUDM;
	}
	@Override
	public String toString() {
		return "UnidadMedida [nombre=" + nombre + ", descripcion=" + descripcion + ", categoriaUDM=" + categoriaUDM
				+ "]";
	}
	
	
}
