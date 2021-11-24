package me.webhop.apollo.api.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import me.webhop.apollo.model.ErrorResponse;
import me.webhop.apollo.security.SecureResource;

@Path("info")
@SecureResource
public class InfoResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ErrorResponse getIt()
    {
        return new ErrorResponse.ErrorResponseBuilder(201, "Got it! It's working.").build();

    }

}
