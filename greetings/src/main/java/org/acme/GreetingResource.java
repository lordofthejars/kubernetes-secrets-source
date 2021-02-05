package org.acme;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() throws IOException {

        // tag::greeting[]
        
        final String envGreeting = System.getenv("GREETING_MESSAGE");

        if (envGreeting != null) {
            return envGreeting;
        }

        java.nio.file.Path confFile = Paths.get("/etc/config/conf.properties");
        if (Files.exists(confFile)) {
            final Properties confProperties = new Properties();
            confProperties.load(Files.newInputStream(confFile));

            if (confProperties.containsKey("greeting.message")) {
                return confProperties.getProperty("greeting.message");
            }

        }

        return "Hello World";

        // end::greeting[]
    }
}