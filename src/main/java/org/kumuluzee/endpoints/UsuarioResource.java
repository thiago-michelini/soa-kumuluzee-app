package org.kumuluzee.endpoints;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.kumuluzee.models.Usuario;
import org.kumuluzee.services.UsuarioService;

@Path("/usuario")
@RequestScoped
public class UsuarioResource {
	
	@Inject
	private UsuarioService service;

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response buscar(@QueryParam("id") Long id, @QueryParam("login") String login,
		@QueryParam("cpf") String cpf) throws Exception {
		List<Usuario> resp = service.buscar(id, login, cpf);

        return Response
        		.ok(resp)
        		.header("Access-Control-Allow-Origin", "http://192.168.41.65")
        		.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept")
        		.build();
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response inserir(Usuario usuario) throws Exception {
		Usuario resp = service.gravar(usuario);

        return Response
        		.ok(resp)
        		.header("Access-Control-Allow-Origin", "http://192.168.41.65")
        		.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept")
        		.build();
	}
	
}
