package com.krakedev.inventarios.bdd;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.inventarios.entidades.Categoria;
import com.krakedev.inventarios.entidades.Producto;
import com.krakedev.inventarios.entidades.UnidadMedida;
import com.krakedev.inventarios.excepciones.KrakedevException;
import com.krakedev.inventarios.utils.ConexionBDD;

public class ProductosBDD {
	public ArrayList<Producto> buscar(String subCadena) throws KrakedevException {
		ArrayList<Producto> productos = new ArrayList<Producto>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Producto producto = null;
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("select prod.codigo_pr, prod.nombre as nombre_producto, udm.codigo_um, udm.descripcion as descripcion_udm, cast(prod.precio_venta as decimal(5,2)), prod.tiene_iva, cast(prod.coste as decimal(5,2)), prod.categoria, cat.nombre as nombre_categoria, prod.stock from productos prod, unidades_medida udm, categorias cat where prod.unidad_M = udm.codigo_um and prod.categoria = cat.codigo_cat and upper(prod.nombre) like ?");
			ps.setString(1, "%" + subCadena.toUpperCase() + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				int codigoProducto = rs.getInt("codigo_pr");
				String nombreProducto = rs.getString("nombre_producto");
				String codigoUDM = rs.getString("codigo_um");
				String descripcionUDM = rs.getString("descripcion_udm");
				BigDecimal precioVenta = rs.getBigDecimal("precio_venta");
				boolean tieneIVA = rs.getBoolean("tiene_iva");
				BigDecimal coste = rs.getBigDecimal("coste");
				int categoria = rs.getInt("categoria");
				String nombreCategoria = rs.getString("nombre_categoria");
				int stock = rs.getInt("stock");

				UnidadMedida udm = new UnidadMedida();
				udm.setNombre(codigoUDM);
				udm.setDescripcion(descripcionUDM);
				
				Categoria cat = new Categoria();
				cat.setCodigo(categoria);
				cat.setNombre(nombreCategoria);
				
				producto = new Producto();
				producto.setCodigo(codigoProducto);
				producto.setNombre(nombreProducto);
				producto.setUdm(udm);
				producto.setPrecioVenta(precioVenta);
				producto.setTieneIVA(tieneIVA);
				producto.setCoste(coste);
				producto.setCategoria(cat);
				producto.setStock(stock);
				
				productos.add(producto);
			}
		} catch (KrakedevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakedevException("Error al consultar Productos. Detalle: " + e.getMessage());
		}
		return productos;
	}
}
