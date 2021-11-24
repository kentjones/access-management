package me.webhop.apollo.api.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import me.webhop.apollo.model.ErrorResponse;

@Path("info")
public class InfoResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public ErrorResponse getIt()
    {
        return new ErrorResponse.ErrorResponseBuilder(201, "Got it! It's working.").build();

    }

}
