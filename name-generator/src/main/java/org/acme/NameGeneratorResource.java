package org.acme;

import java.util.Random;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/generate")
public class NameGeneratorResource {

    private static final String[] NAMES = new String[] {
        "Ada", "Alexandra", "Burr", "Edson", "Kamesh", "Sebi", "Anna", "Gavina"
    };

    private static final Random r = new Random();

    @GET
    @Path("/name")
    @Produces(MediaType.TEXT_PLAIN)
    @RolesAllowed("Subscriber")
    public String generate() {
        return NAMES[generateRandomIndex()];
    }

    private int generateRandomIndex() {
        return r.nextInt(NAMES.length);
    }
}