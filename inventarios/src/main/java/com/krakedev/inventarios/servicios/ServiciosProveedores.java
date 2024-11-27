package com.krakedev.inventarios.servicios;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.inventarios.bdd.ProveedoresBDD;
import com.krakedev.inventarios.entidades.Proveedor;
import com.krakedev.inventarios.excepciones.KrakedevException;
@Path("proveedores")
public class ServiciosProveedores {
	
	@Path("buscar/{subcadena}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarNombre(@PathParam("subcadena") String subcadena){
		ProveedoresBDD provBDD = new ProveedoresBDD(); 
		ArrayList<Proveedor> proveedores = null;
		try {
			proveedores = provBDD.buscar(subcadena);
			return Response.ok(proveedores).build();
		} catch (KrakedevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@Path("crear")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crear(Proveedor proveedor) {
		ProveedoresBDD prov = new ProveedoresBDD();
		try {
			prov.insertar(proveedor);
			return Response.ok().build();
		} catch (KrakedevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@Path("buscarIdentificador/{identificador}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPorIdentificador(@PathParam("identificador") String identificador){
		ProveedoresBDD provBDD = new ProveedoresBDD(); 
		Proveedor prov = null;
		try {
			prov = provBDD.recuperarProveedor(identificador);
			return Response.ok(prov).build();
		} catch (KrakedevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
}

