package com.krakedev.inventarios.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.inventarios.entidades.Proveedor;
import com.krakedev.inventarios.entidades.TipoDocumento;
import com.krakedev.inventarios.excepciones.KrakedevException;
import com.krakedev.inventarios.utils.ConexionBDD;

public class ProveedoresBDD {
	public ArrayList<Proveedor> buscar(String subCadena) throws KrakedevException {
		ArrayList<Proveedor> proveedores = new ArrayList<Proveedor>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Proveedor proveedor = null;
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("select prov.identificador,prov.tipo_documento, td.descripcion, prov.nombre,prov.telefono,prov.correo,prov.direccion from proveedores prov,tipo_documento td where prov.tipo_documento = td.codigo and upper(prov.nombre) like ?");
			ps.setString(1, "%" + subCadena.toUpperCase() + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				String identificador = rs.getString("identificador");
				String tipoDocumento = rs.getString("tipo_documento");
				String descripcionTD=rs.getString("descripcion");
				String nombre = rs.getString("nombre");
				String telefono = rs.getString("telefono");
				String correo = rs.getString("correo");
				String direccion = rs.getString("direccion");
				TipoDocumento td= new TipoDocumento(tipoDocumento, descripcionTD);
				proveedor = new Proveedor(identificador, td, nombre, telefono, correo, direccion);
				proveedores.add(proveedor);
			}
		} catch (KrakedevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakedevException("Error al consultar. Detalle: " + e.getMessage());
		}
		return proveedores;
	}
	
	
	
	public void insertar(Proveedor prov) throws KrakedevException {
		Connection con = null;
		try {
			con = ConexionBDD.obtenerConexion();
			PreparedStatement ps = con.prepareStatement("insert into proveedores(identificador,tipo_documento,nombre,telefono,correo,direccion) values(?,?,?,?,?,?)");
			ps.setString(1, prov.getIdentificador());
			ps.setString(2, prov.getTipoDocumento().getCodigo());
			ps.setString(3, prov.getNombre());
			ps.setString(4, prov.getTelefono());
			ps.setString(5, prov.getCorreo());
			ps.setString(6, prov.getDireccion());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakedevException("Error al insertar el Proveedor. Detalle: "+e.getMessage());
		} catch (KrakedevException e) {
			throw e;
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
}
