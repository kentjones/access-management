package me.webhop.apollo.util;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.core.Response;
import me.webhop.apollo.model.ErrorResponse;

public class RequestContextHelper {


    public static void abortWith403Forbidden(ContainerRequestContext context, ErrorResponse er)
    {

        context.abortWith(Response
                .status(Response.Status.FORBIDDEN)
                .entity(er)
                .build());
    }
    public static void abortWith401Unauthorized(ContainerRequestContext context, ErrorResponse er)
    {
        context.abortWith(Response
                .status(Response.Status.UNAUTHORIZED)
                .entity(er)
                .build());
    }
    public static void abortWith500InternalServerError(ContainerRequestContext context, ErrorResponse er)
    {
        context.abortWith(Response
                .status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(er)
                .build());
    }
}
