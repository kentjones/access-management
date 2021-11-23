package me.webhop.apollo;

import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("api")
public class ApplicationConfig extends ResourceConfig {

    public ApplicationConfig() {

        packages("me.webhop.apollo.api", "me.webhop.apollo.security");
    }
}
