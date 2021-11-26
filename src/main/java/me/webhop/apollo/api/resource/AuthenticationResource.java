package me.webhop.apollo.api.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import me.webhop.apollo.model.ErrorResponse;

import javax.ws.rs.core.Response;

import static me.webhop.apollo.model.ErrorResponse.ErrorResponseBuilder;

@Path("auth")
public class AuthenticationResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get()
    {
        ErrorResponse response = new ErrorResponseBuilder(201, "Authentication resource is working.").build();

        return Response.ok().entity(response).build();

    }

}
