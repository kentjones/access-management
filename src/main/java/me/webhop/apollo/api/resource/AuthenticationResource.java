package me.webhop.apollo.api.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import me.webhop.apollo.model.ErrorResponse;
import me.webhop.apollo.security.SecureResource;

import static me.webhop.apollo.model.ErrorResponse.ErrorResponseBuilder;

@Path("auth")
public class AuthenticationResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ErrorResponse get()
    {
        return new ErrorResponseBuilder(201, "Authentication resource is working.").build();

    }

}
