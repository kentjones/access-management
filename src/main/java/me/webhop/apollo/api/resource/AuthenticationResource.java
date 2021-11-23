package me.webhop.apollo.api.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("auth")
public class AuthenticationResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getIt()
    {
        return "Authentication resource is working.";
    }

}
