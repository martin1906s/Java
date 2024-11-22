package com.krakedev.inventarios.bdd;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import com.krakedev.inventarios.entidades.DetallePedido;
import com.krakedev.inventarios.entidades.Pedido;
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
			
			ArrayList<DetallePedido> detallesPedido=pedido.getDetalles();
			DetallePedido det;
			for(int i=0; i<detallesPedido.size();i++) {
				det=detallesPedido.get(i);
				psDet=con.prepareStatement("insert into detalle_pedido(cabecera_pedido,producto,cantidad_solicitada,subtotal,cantida_recibida) values(?,?,?,?,?)");
				psDet.setInt(1, codigoCabecera);
				psDet.setInt(2, det.getProducto().getCodigo());
				psDet.setInt(3, det.getCantidad());
				BigDecimal pv =det.getProducto().getPrecioVenta();
				BigDecimal cantidad= new BigDecimal(det.getCantidad());
				BigDecimal subtotal=pv.multiply(cantidad);
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
	
}
