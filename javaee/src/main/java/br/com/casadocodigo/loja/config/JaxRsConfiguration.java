package br.com.casadocodigo.loja.config;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.POST;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

@ApplicationPath("/services")
public class JaxRsConfiguration extends Application {
	
	@POST
	public Response pagar(@QueryParam("uuid") String uuid) {
	    System.out.println(uuid);
	    return null;
	}

}
