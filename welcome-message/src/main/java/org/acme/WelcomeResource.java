package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/welcome")
public class WelcomeResource {

    @RestClient
    NameService nameService;

    @ConfigProperty(name = "name.service.token")
    String token;

    @GET
    @Path("/message")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return nameService.generateName("Bearer " + token);
    }
}