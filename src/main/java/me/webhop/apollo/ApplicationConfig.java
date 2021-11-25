package me.webhop.apollo;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("api")
public class ApplicationConfig extends ResourceConfig {

    public ApplicationConfig() {

        packages("me.webhop.apollo.api", "me.webhop.apollo.security", "me.webhop.apollo.model", "com.fasterxml.jaxrs.json");
        register(JacksonJsonProvider.class);
    }
}
