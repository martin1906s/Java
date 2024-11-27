package com.krakedev.inventarios.bdd;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.inventarios.entidades.Categoria;
import com.krakedev.inventarios.entidades.CategoriaUDM;
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
			ps = con.prepareStatement(
					"select prod.codigo_pr, prod.nombre as nombre_producto, udm.codigo_um, udm.descripcion as descripcion_udm, cast(prod.precio_venta as decimal(5,2)), prod.tiene_iva, cast(prod.coste as decimal(5,2)), prod.categoria, cat.nombre as nombre_categoria, prod.stock from productos prod, unidades_medida udm, categorias cat where prod.unidad_M = udm.codigo_um and prod.categoria = cat.codigo_cat and upper(prod.nombre) like ?");
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

	public void insertar(Producto prod) throws KrakedevException {
		Connection con = null;
		try {
			con = ConexionBDD.obtenerConexion();
			PreparedStatement ps = con.prepareStatement(
					"insert into productos(nombre,unidad_m,precio_venta,tiene_iva,coste,categoria,stock) values (?,?,?,?,?,?,?)");
			ps.setString(1, prod.getNombre());
			ps.setString(2, prod.getUdm().getNombre());
			ps.setBigDecimal(3, prod.getPrecioVenta());
			ps.setBoolean(4, prod.isTieneIVA());
			ps.setBigDecimal(5, prod.getCoste());
			ps.setInt(6, prod.getCategoria().getCodigo());
			ps.setInt(7, prod.getStock());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakedevException("Error al insertar el Producto. Detalle: " + e.getMessage());
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

	public void actualizarProducto(Producto prod) throws KrakedevException {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement(
					"update productos set nombre=?, unidad_m= ?, precio_venta=?, tiene_iva=?, coste=?, categoria=? where codigo_pr=?");
			ps.setString(1, prod.getNombre());
			ps.setString(2, prod.getUdm().getNombre());
			ps.setBigDecimal(3, prod.getPrecioVenta());
			ps.setBoolean(4, prod.isTieneIVA());
			ps.setBigDecimal(5, prod.getCoste());
			ps.setInt(6, prod.getCategoria().getCodigo());
			ps.setInt(7, prod.getCodigo());
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

	public Producto buscarProductoPorCodigo(int codPedido) throws KrakedevException {
		Producto pro = new Producto();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = ConexionBDD.obtenerConexion();

			ps = con.prepareStatement(
					"select pro.codigo_pr,pro.nombre as nombre_producto,\r\n"
					+ "pro.unidad_m,um.descripcion as descripcion_um, um.categoria_um, cum.nombre as nombre_cum,\r\n"
					+ "pro.precio_venta,pro.tiene_iva,pro.coste,pro.categoria,cat.nombre as nombre_cat,cat.categoria_padre,\r\n"
					+ "pro.stock from productos pro,\r\n"
					+ "unidades_medida um,categorias_um cum, categorias cat\r\n"
					+ "where um.codigo_um=pro.unidad_m\r\n"
					+ "and um.categoria_um=cum.codigo_um\r\n"
					+ "and cat.codigo_cat = pro.categoria\r\n"
					+ "and pro.codigo_pr=?");
			ps.setInt(1, codPedido);
			rs = ps.executeQuery();
			if (rs.next()) {
				int producto = rs.getInt("codigo_pr");
				String nombrePro = rs.getString("nombre_producto");
				String unidadMPro = rs.getString("unidad_m");
				String descripcionUM = rs.getString("descripcion_um");
				String categoriaUM = rs.getString("categoria_um");
				String nombreCatUDM = rs.getString("nombre_cum");
				BigDecimal precioVenta = rs.getBigDecimal("precio_venta");
				boolean tieneIva = rs.getBoolean("tiene_iva");
				BigDecimal coste = rs.getBigDecimal("coste");
				Integer categoria = rs.getInt("categoria");
				String nombreCat = rs.getString("nombre_cat");
				Integer codCategoriaPadre = rs.getObject("categoria_padre", Integer.class);
				Categoria categoriaPadre = null;

				if (codCategoriaPadre != null) {
					categoriaPadre = new Categoria();
					categoriaPadre.setCodigo(codCategoriaPadre);
				}
				Categoria categoriaP = new Categoria(categoria, nombreCat, categoriaPadre);
				int stock = rs.getInt("stock");


				
				CategoriaUDM catUDM = new CategoriaUDM();
				catUDM.setCodigo(categoriaUM);
				catUDM.setNombre(nombreCatUDM);

				UnidadMedida um = new UnidadMedida();
				um.setNombre(unidadMPro);
				um.setDescripcion(descripcionUM);
				um.setCategoriaUDM(catUDM);

				Categoria cat = new Categoria();
				cat.setCodigo(categoria);
				cat.setNombre(nombreCat);
				cat.setCategoriaPadre(categoriaP);

				pro.setCodigo(producto);
				pro.setNombre(nombrePro);
				pro.setUdm(um);
				pro.setPrecioVenta(precioVenta);
				pro.setTieneIVA(tieneIva);
				pro.setCoste(coste);
				pro.setCategoria(cat);
				pro.setStock(stock);



			}

		} catch (KrakedevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakedevException("Error al buscar producto por codigo. Detalle: " + e.getMessage());
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return pro;
	}

}
