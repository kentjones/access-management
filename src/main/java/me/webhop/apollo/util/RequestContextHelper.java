package me.webhop.apollo.util;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.core.Response;
import me.webhop.apollo.model.ErrorResponse;

public class RequestContextHelper {


    public static void abortWith403Forbidden(ContainerRequestContext context)
    {
        ErrorResponse er = new ErrorResponse();
        er.setCode(40301);
        er.setStatue(403);
        er.setMessage("User does not have the correct privileges");
        er.setDeveloperMessage("The security context reported this error.");

        context.abortWith(Response
                .status(Response.Status.FORBIDDEN)
                .entity(er)
                .build());
    }
    public static void abortWith401Unauthorized(ContainerRequestContext context)
    {
        ErrorResponse er = new ErrorResponse();
        er.setCode(40101);
        er.setStatue(401);
        er.setMessage("User cannot access the resource");
        er.setDeveloperMessage("User Authorization Token is empty");
        context.abortWith(Response
                .status(Response.Status.UNAUTHORIZED)
                .entity(er)
                .build());
    }
}
