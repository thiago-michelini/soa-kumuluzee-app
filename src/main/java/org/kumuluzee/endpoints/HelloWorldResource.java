package org.kumuluzee.endpoints;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.kumuluzee.models.Cliente;

@Path("/rest")
@RequestScoped
public class HelloWorldResource {
	
	@PersistenceContext(unitName = "hsql-PU")
	private EntityManager em;

	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response hello(Cliente req) throws Exception {
		System.out.println("id->"+req.getId()+" nome->"+req.getNome()+" nasc->"
			+req.getNascimento());
		
		System.out.println("dtRequest->"+req.getDataHoraRequisicao());
		
		em.getTransaction().begin();
		
        Cliente resp = new Cliente();
        resp.setId(2L);
        resp.setIdade(42);
        resp.setDataHoraRequisicao(LocalDateTime.now());
        resp.setNascimento(LocalDate.now());

        return Response.ok(resp).build();
	}
	
}
