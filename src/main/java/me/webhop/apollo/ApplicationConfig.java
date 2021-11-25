package me.webhop.apollo;

import org.apache.log4j.Level;
import org.glassfish.jersey.server.ResourceConfig;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import jakarta.ws.rs.ApplicationPath;

import org.apache.log4j.Logger;


@ApplicationPath("api")
public class ApplicationConfig extends ResourceConfig {

    private final Logger logger = Logger.getLogger(ApplicationConfig.class);
    public ApplicationConfig() {

        packages("me.webhop.apollo.api", "me.webhop.apollo.security", "me.webhop.apollo.model", "com.fasterxml.jaxrs.json");

        register(JacksonJsonProvider.class);

        logger.log(Level.INFO, "Registering web resources");
    }
}
