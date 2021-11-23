package me.webhop.apollo.api.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import me.webhop.apollo.model.ErrorResponse;

@Path("auth")
public class AuthenticationResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ErrorResponse getIt()
    {
        ErrorResponse er = new ErrorResponse();

        return "{\"message\": \"Authentication resource is working.\""};
    }

}
