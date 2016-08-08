package org.kumuluzee.endpoints;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.kumuluzee.models.EstadoTreinamento;
import org.kumuluzee.services.EstadoTreinamentoService;

@Path("/estado-treinamento")
@RequestScoped
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class EstadoTreinamentoResource {
	
	@Inject
	private EstadoTreinamentoService service;
	
	@POST
	public Response inserir(EstadoTreinamento et) throws Exception {
		EstadoTreinamento resp = service.gravar(et);
		return Response.ok(resp).build();
	}
	
}
