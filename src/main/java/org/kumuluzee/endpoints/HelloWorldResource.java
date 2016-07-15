package org.kumuluzee.endpoints;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.kumuluzee.models.Cliente;
import org.kumuluzee.services.ClienteService;

@Path("/rest")
@RequestScoped
public class HelloWorldResource {
	
	@Inject
	private ClienteService service;

	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response hello(Cliente req) throws Exception {
		System.out.println("id->"+req.getId()+" nome->"+req.getNome()+" nasc->"
			+req.getNascimento());
		
		System.out.println("dtRequest->"+req.getDataHoraRequisicao());
		
        Cliente resp = service.gravar();

        return Response.ok(resp).build();
	}
	
}
