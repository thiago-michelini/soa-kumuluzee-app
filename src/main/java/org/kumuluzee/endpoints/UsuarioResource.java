package org.kumuluzee.endpoints;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.kumuluzee.models.Usuario;
import org.kumuluzee.services.UsuarioService;

@Path("/usuario")
@RequestScoped
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class UsuarioResource {
	
	@Inject
	private UsuarioService service;

	@GET
	public Response buscar(@QueryParam("id") Long id, @QueryParam("login") String login,
		@QueryParam("cpf") String cpf) throws Exception {
		List<Usuario> resp = service.buscar(id, login, cpf);

        return Response.ok(resp).build();
	}
	
	@POST
	public Response inserir(Usuario usuario) throws Exception {
		return gravar(usuario);
	}
	
	@PUT
	public Response editar(Usuario usuario) throws Exception {
		return gravar(usuario);
	}
	
	@DELETE
	public Response excluir(Usuario usuario) throws Exception {
		service.excluir(usuario);
		return Response.ok().build();
	}
	
	private Response gravar(Usuario u) throws Exception {
		Usuario resp = service.gravar(u);
        return Response.ok(resp).build();
	}
	
}
