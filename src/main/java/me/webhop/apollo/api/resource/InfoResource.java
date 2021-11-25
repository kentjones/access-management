package me.webhop.apollo.api.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.webhop.apollo.model.ErrorResponse;
import me.webhop.apollo.security.SecureResource;

@Path("info")
@SecureResource
public class InfoResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response execute()
    {
        ErrorResponse response = new ErrorResponse.ErrorResponseBuilder(201, "Got it! It's working.").build();

        return Response.ok().entity(response).build();

    }

}
