package org.kumuluzee.endpoints;

import java.util.logging.Logger;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.kumuluzee.jaxrs.filter.LiberaCrossDomainResponseFilter;

@ApplicationPath("/rest-API")
public class RestApplication extends ResourceConfig {

	public RestApplication() {
		// registra no Jersey os pacotes contendo as classes de resource REST
		packages("org.kumuluzee.endpoints");
		
		// define como default o log do java
		Logger log = Logger.getGlobal();
		register(new LoggingFilter(log, true));
		
		//registrando filtro para liberacao de acesso Cross Domain
		register(new LiberaCrossDomainResponseFilter());
	}
	
}
