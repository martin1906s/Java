package com.krakedev.inventarios.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.inventarios.entidades.Categoria;
import com.krakedev.inventarios.excepciones.KrakedevException;
import com.krakedev.inventarios.utils.ConexionBDD;

public class CategoriaBDD {
	public void crearCategoria(Categoria cat) throws KrakedevException {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("insert into categorias(nombre, categoria_padre) values(?,?)");
			ps.setString(1, cat.getNombre());
			if(cat.getCategoriaPadre() != null) {
				ps.setInt(2, cat.getCategoriaPadre().getCodigo());
			}else {
				ps.setNull(2, java.sql.Types.INTEGER);
			}
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakedevException("Error al crear Categoria. Detalle: " + e.getMessage());
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public void actualizarCategoria(Categoria cat) throws KrakedevException {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("update categorias set nombre=?, categoria_padre=? where codigo_cat=?");
			ps.setString(1, cat.getNombre());
			ps.setInt(2, cat.getCategoriaPadre().getCodigo());
			ps.setInt(3, cat.getCodigo());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakedevException("Error al actualizar el producto. Detalle: " + e.getMessage());
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public ArrayList<Categoria> recuperar() throws KrakedevException {
		ArrayList<Categoria> categorias = new ArrayList<Categoria>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Categoria categoria = null;

		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("select * from categorias");
			rs = ps.executeQuery();
			while (rs.next()) {
				Integer codigo = rs.getInt("codigo_cat");
				String nombre = rs.getString("nombre");
	            Integer codCategoriaPadre = rs.getObject("categoria_padre", Integer.class);
	            Categoria categoriaPadre = null;

	            if (codCategoriaPadre != null) {
	                categoriaPadre = new Categoria();
	                categoriaPadre.setCodigo(codCategoriaPadre);
	            }
	            categoria = new Categoria(codigo, nombre, categoriaPadre);
				categorias.add(categoria);
			}
		} catch (KrakedevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakedevException("Error al recuperar Categorias. Detalle: " + e.getMessage());
		}
		return categorias;
	}

}
