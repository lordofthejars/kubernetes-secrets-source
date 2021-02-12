package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/generate")
@RegisterRestClient
public interface NameService {
    
    @GET
    @Path("/name")
    @Produces(MediaType.TEXT_PLAIN)
    String generateName(@HeaderParam("Authorization") String bearerToken);
}
