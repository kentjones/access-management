package me.webhop.apollo.util;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.core.Response;

public class RequestContextHelper {


    public static void abortWith403Forbidden(ContainerRequestContext context)
    {
        context.abortWith(Response
                    .status(Response.Status.FORBIDDEN)
                    .build());
    }
    public static void abortWith401Unauthorized(ContainerRequestContext context)
    {

        context.abortWith(Response
                .status(Response.Status.UNAUTHORIZED)
                .entity("User cannot access the resource")
                .build());
    }
}
