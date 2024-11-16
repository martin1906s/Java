package com.krakedev.inventarios.servicios;

import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.inventarios.bdd.TipoDocumentoBDD;
import com.krakedev.inventarios.entidades.TipoDocumento;
import com.krakedev.inventarios.excepciones.KrakedevException;

@Path("tipodocumento")
public class ServicioTipoDocumentos {
	
	@Path("recuperar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(){
		TipoDocumentoBDD documentoBDD = new TipoDocumentoBDD(); 
		ArrayList<TipoDocumento> documentos = null;
		try {
			documentos = documentoBDD.buscar();
			return Response.ok(documentos).build();
		} catch (KrakedevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
}

