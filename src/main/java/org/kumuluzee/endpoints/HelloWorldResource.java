package org.kumuluzee.endpoints;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import org.kumuluzee.models.Cliente;

@Path("/rest")
public class HelloWorldResource {

	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response hello(Cliente req) throws DatatypeConfigurationException {
		System.out.println("id->"+req.getId()+" nome->"+req.getNome()+" nasc->"
			+req.getNascimento());
		
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(new Date());
		System.out.println(DatatypeFactory.newInstance().newXMLGregorianCalendar(gc));
		
		Map<String, String> json = new HashMap<>();
        json.put("framework", "KumuluzEE");

        return Response.ok(json).build();
	}
	
}
