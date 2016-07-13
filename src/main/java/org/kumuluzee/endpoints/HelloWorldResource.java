package org.kumuluzee.endpoints;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/rest")
public class HelloWorldResource {

	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response hello(Map<String, String> req) {
		Map<String, String> json = new HashMap<>();
        json.put("framework", "KumuluzEE");

        return Response.ok(json).build();
	}
	
}
