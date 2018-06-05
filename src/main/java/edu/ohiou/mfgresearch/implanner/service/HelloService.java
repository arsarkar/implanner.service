package edu.ohiou.mfgresearch.implanner.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */

@Path("/hello")
public class HelloService {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getIt() {
		return "Service said Hello!";
	}

    @GET
    @Path("/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCustomIt(@PathParam("name") String name) {
    	return "Hello "+name;
    }
    
    
}
