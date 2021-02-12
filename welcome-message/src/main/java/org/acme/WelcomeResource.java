package org.acme;

import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;


@Path("/welcome")
public class WelcomeResource {

    @RestClient
    NameService nameService;

    @ConfigProperty(name = "name-service-token")
    String token;

    private static Random r = new Random();

    @GET
    @Path("/message")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        String welcomeMessage = randomMessage(Welcome.listAll());
        String name = nameService.generateName("Bearer " + token);

        return welcomeMessage + " " + name;
    }

    private String randomMessage(List<Welcome> welcomeMessages) {
        int size = welcomeMessages.size();
        return welcomeMessages.get(r.nextInt(size)).message;
    }
}