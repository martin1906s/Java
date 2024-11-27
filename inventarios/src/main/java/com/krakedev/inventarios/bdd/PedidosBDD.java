package com.krakedev.inventarios.bdd;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import com.krakedev.inventarios.entidades.Categoria;
import com.krakedev.inventarios.entidades.CategoriaUDM;
import com.krakedev.inventarios.entidades.DetallePedido;
import com.krakedev.inventarios.entidades.EstadoPedido;
import com.krakedev.inventarios.entidades.Pedido;
import com.krakedev.inventarios.entidades.Producto;
import com.krakedev.inventarios.entidades.Proveedor;
import com.krakedev.inventarios.entidades.TipoDocumento;
import com.krakedev.inventarios.entidades.UnidadMedida;
import com.krakedev.inventarios.excepciones.KrakedevException;
import com.krakedev.inventarios.utils.ConexionBDD;

public class PedidosBDD {
	public void insertar(Pedido pedido) throws KrakedevException {
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement psDet = null;
		Date fechaActual = new Date();
		java.sql.Date fechaSQL = new java.sql.Date(fechaActual.getTime());
		ResultSet rsClave = null;
		int codigoCabecera = 0;
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("insert into cabecera_pedido(proveedor,fecha,estado) values(?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, pedido.getProveedor().getIdentificador());
			ps.setDate(2, fechaSQL);
			ps.setString(3, "S");
			ps.executeUpdate();
			rsClave = ps.getGeneratedKeys();

			if (rsClave.next()) {
				codigoCabecera = rsClave.getInt(1);
			}

			ArrayList<DetallePedido> detallesPedido = pedido.getDetalles();
			DetallePedido det;
			for (int i = 0; i < detallesPedido.size(); i++) {
				det = detallesPedido.get(i);
				psDet = con.prepareStatement(
						"insert into detalle_pedido(cabecera_pedido,producto,cantidad_solicitada,subtotal,cantida_recibida) values(?,?,?,?,?)");
				psDet.setInt(1, codigoCabecera);
				psDet.setInt(2, det.getProducto().getCodigo());
				psDet.setInt(3, det.getCantidad());
				BigDecimal pv = det.getProducto().getPrecioVenta();
				BigDecimal cantidad = new BigDecimal(det.getCantidad());
				BigDecimal subtotal = pv.multiply(cantidad);
				psDet.setBigDecimal(4, subtotal);
				psDet.setInt(5, 0);

				psDet.executeUpdate();
			}

		} catch (KrakedevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakedevException("Error al agregar Pedidos. Detalle: " + e.getMessage());
		}
	}

	public void actualizar(Pedido pedido) throws KrakedevException {
		Connection con = null;
		PreparedStatement psCabecera = null;
		PreparedStatement psDetalle = null;
		PreparedStatement psHistorial = null;
		Date fechaActual = new Date();
		Timestamp fechaHoraActual = new Timestamp(fechaActual.getTime());
		try {
			con = ConexionBDD.obtenerConexion();

			psCabecera = con.prepareStatement("update cabecera_pedido set estado = 'R' where numero_pedido = ?");
			psCabecera.setInt(1, pedido.getNumeroPedido());
			psCabecera.executeUpdate();

			ArrayList<DetallePedido> detalles = pedido.getDetalles();
			for (int i = 0; i < detalles.size(); i++) {
				DetallePedido detalle = detalles.get(i);
				psDetalle = con.prepareStatement(
						"update detalle_pedido set cantida_recibida = ?, subtotal = ? where codigo = ?");
				psDetalle.setInt(1, detalle.getCantidadRecibida());
				BigDecimal subtotal = detalle.getProducto().getPrecioVenta()
						.multiply(new BigDecimal(detalle.getCantidadRecibida()));
				psDetalle.setBigDecimal(2, subtotal);
				psDetalle.setInt(3, detalle.getCodigo());
				psDetalle.executeUpdate();
				psHistorial = con.prepareStatement(
						"insert into historial_stock(fecha,referencia,producto,cantidad)\r\n" + "values(?,?,?,?)");
				psHistorial.setTimestamp(1, fechaHoraActual);
				psHistorial.setString(2, "Pedido " + pedido.getNumeroPedido());
				psHistorial.setInt(3, detalle.getProducto().getCodigo());
				psHistorial.setInt(4, detalle.getCantidadRecibida());
				psHistorial.executeUpdate();

			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakedevException("Error al actualizar el pedido. Detalle: " + e.getMessage());
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

	public ArrayList<DetallePedido> buscarPedidosPorProveedor(String proveedor) throws KrakedevException {
		ArrayList<DetallePedido> detalles = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = ConexionBDD.obtenerConexion();

			ps = con.prepareStatement(
					"select cp.numero_pedido,cp.proveedor,prov.tipo_documento, td.descripcion as descripcion_td,prov.nombre as nombre_prov,\r\n"
							+ "prov.telefono, prov.correo, prov.direccion,\r\n"
							+ "cp.fecha as fecha_pedido, cp.estado as estado_pedido,\r\n"
							+ "ep.descripcion as descripcion_ep, dp.codigo,dp.producto,pro.nombre as nombre_producto,\r\n"
							+ "pro.unidad_m,um.descripcion as descripcion_um, um.categoria_um, cum.nombre as nombre_cum,\r\n"
							+ "pro.precio_venta,pro.tiene_iva,pro.coste,pro.categoria,cat.nombre as nombre_cat,cat.categoria_padre,\r\n"
							+ "pro.stock,dp.cantidad_solicitada,dp.subtotal,dp.cantida_recibida\r\n"
							+ "from cabecera_pedido cp, estado_pedido ep, detalle_pedido dp,productos pro,\r\n"
							+ "unidades_medida um,categorias_um cum, categorias cat, proveedores prov, tipo_documento td\r\n"
							+ "where ep.codigo=cp.estado and\r\n" + "cp.numero_pedido=dp.cabecera_pedido\r\n"
							+ "and dp.producto=pro.codigo_pr\r\n" + "and um.codigo_um=pro.unidad_m\r\n"
							+ "and um.categoria_um=cum.codigo_um\r\n" + "and cat.codigo_cat = pro.categoria\r\n"
							+ "and cp.proveedor = prov.identificador\r\n" + "and prov.tipo_documento = td.codigo\r\n"
							+ "and cp.proveedor = ?");
			ps.setString(1, proveedor);
			rs = ps.executeQuery();
			while (rs.next()) {
				int numeroPedido = rs.getInt("numero_pedido");
				String identificador = rs.getString("proveedor");
				String tipoDoc = rs.getString("tipo_documento");
				String descripcionTd = rs.getString("descripcion_td");
				String nombreProv = rs.getString("nombre_prov");
				String telefono = rs.getString("telefono");
				String correo = rs.getString("correo");
				String direccion = rs.getString("direccion");
				Date fecha = rs.getDate("fecha_pedido");
				String estadoPedido = rs.getString("estado_pedido");
				String descripcionEP = rs.getString("descripcion_ep");
				int codigoDP = rs.getInt("codigo");
				int producto = rs.getInt("producto");
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
				int cantidadSolic = rs.getInt("cantidad_solicitada");
				BigDecimal subtotal = rs.getBigDecimal("subtotal");
				int cantidadReci = rs.getInt("cantida_recibida");

				EstadoPedido ep = new EstadoPedido();
				ep.setCodigo(estadoPedido);
				ep.setDescripcion(descripcionEP);

				TipoDocumento td = new TipoDocumento();
				td.setCodigo(tipoDoc);
				td.setDescripcion(descripcionTd);

				Proveedor prov = new Proveedor();
				prov.setIdentificador(identificador);
				prov.setTipoDocumento(td);
				prov.setNombre(nombreProv);
				prov.setTelefono(telefono);
				prov.setCorreo(correo);
				prov.setDireccion(direccion);

				Pedido pedido = new Pedido();
				pedido.setNumeroPedido(numeroPedido);
				pedido.setProveedor(prov);
				pedido.setFecha(fecha);
				pedido.setEstado(ep);

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

				Producto pro = new Producto();
				pro.setCodigo(producto);
				pro.setNombre(nombrePro);
				pro.setUdm(um);
				pro.setPrecioVenta(precioVenta);
				pro.setTieneIVA(tieneIva);
				pro.setCoste(coste);
				pro.setCategoria(cat);
				pro.setStock(stock);

				DetallePedido dp = new DetallePedido();
				dp.setCodigo(codigoDP);
				dp.setCabecera(pedido);
				dp.setProducto(pro);
				dp.setCantidad(cantidadSolic);
				dp.setSubtotal(subtotal);
				dp.setCantidadRecibida(cantidadReci);

				detalles.add(dp);

			}

		} catch (KrakedevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakedevException("Error al buscar pedido por proveedor. Detalle: " + e.getMessage());
		}finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return detalles;
	}

}
