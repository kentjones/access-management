package me.webhop.apollo;

import me.webhop.apollo.api.resource.AuthenticationResource;
import me.webhop.apollo.api.resource.InfoResource;
import org.glassfish.jersey.server.ResourceConfig;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import jakarta.ws.rs.ApplicationPath;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


@ApplicationPath("api")
public class ApplicationConfig extends ResourceConfig {

    private final Logger logger = LoggerFactory.getLogger(ApplicationConfig.class);
    public ApplicationConfig() {

        packages("me.webhop.apollo.api", "me.webhop.apollo.security", "me.webhop.apollo.model", "com.fasterxml.jaxrs.json");

        register(JacksonJsonProvider.class);

        logger.info("Registering web resources");
    }
}
