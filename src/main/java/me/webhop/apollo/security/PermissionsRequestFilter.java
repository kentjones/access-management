package me.webhop.apollo.security;

import jakarta.annotation.Priority;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ResourceContext;
import jakarta.ws.rs.container.ResourceInfo;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.ext.Provider;

import me.webhop.apollo.model.ErrorResponse;
import static me.webhop.apollo.model.ErrorResponse.ErrorResponseBuilder;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

import static me.webhop.apollo.util.RequestContextHelper.*;
import static me.webhop.apollo.util.ResourceHelper.*;

import java.io.IOException;
import java.lang.reflect.Method;

@Provider
@Priority(Priorities.AUTHENTICATION)
public class PermissionsRequestFilter implements ContainerRequestFilter {

    @Context private ResourceInfo resourceInfo;
    @Context private ResourceContext resourceContext;
    @Context private HttpServletRequest request;

    private static final String AuthorizationToken = "x-auth-token";

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        //
        // Step 01 - get Principal
        //
        final ApolloSecurityContext sc = new ApolloSecurityContext(new ApolloPrincipal("Demo User"));
        requestContext.setSecurityContext(sc);


        try {

            Class<?> resourceClass = resourceInfo.getResourceClass();
            Method   resourceMethod = resourceInfo.getResourceMethod();

            if(secureResource(resourceClass, resourceMethod))
            {
                if(!sc.isUserInRole("privileged")){
                    ErrorResponse er = new ErrorResponseBuilder(403, "User does not have the correct privileges")
                            .setStatusCode(40301)
                            .setDeveloperMessage("The security context reported this error.")
                            .build();
                    abortWith403Forbidden(requestContext, er);
                }

                String authorizationToken = StringUtils.trim(requestContext.getHeaderString(AuthorizationToken));

                if(StringUtils.isEmpty(authorizationToken)){
                    ErrorResponse er = new ErrorResponseBuilder(401, "User must be signed in to access this resource")
                            .setStatusCode(40101)
                            .setDeveloperMessage("User Authorization Token is empty")
                            .build();

                    abortWith401Unauthorized(requestContext, er);
                }
                if(!authorizationToken.equalsIgnoreCase("authorized")){
                    ErrorResponse er = new ErrorResponseBuilder(403, "You must have authority to access this resource")
                            .setStatusCode(40302)
                            .setDeveloperMessage(String.format("Authorization token: %s", authorizationToken))
                            .build();

                    abortWith403Forbidden(requestContext, er);
                }

            }
        } catch (Exception e) {
            ErrorResponse er = new ErrorResponseBuilder(500, e.getMessage())
                                .setStatusCode(50001)
                                .setDeveloperMessage("Permission Request throw an error. See logs for details")
                                .build();

            abortWith500InternalServerError(requestContext, er);
        }
    }
}
