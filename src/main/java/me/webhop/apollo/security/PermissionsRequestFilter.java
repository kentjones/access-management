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
                    ErrorResponse er = new ErrorResponse();
                    er.setCode(40301);
                    er.setStatue(403);
                    er.setMessage("User does not have the correct privileges");
                    er.setDeveloperMessage("The security context reported this error.");

                    abortWith403Forbidden(requestContext, er);
                }

                String token = requestContext.getHeaderString(AuthorizationToken);
                if(StringUtils.isEmpty(token)){
                    ErrorResponse er = new ErrorResponse();
                    er.setCode(40101);
                    er.setStatue(401);
                    er.setMessage("User must be signed in to access this resource");
                    er.setDeveloperMessage("User Authorization Token is empty");

                    abortWith401Unauthorized(requestContext, er);
                }
                if(token.equalsIgnoreCase("authorized")){
                    ErrorResponse er = new ErrorResponse();
                    er.setCode(40302);
                    er.setStatue(403);
                    er.setMessage("You must have authority to access this resource");
                    er.setDeveloperMessage("Grant user authority to this resource");

                    abortWith403Forbidden(requestContext, er);

                }

            }


        } catch (Exception e) {
            ErrorResponse er = new ErrorResponse();
            er.setCode(50001);
            er.setStatue(500);
            er.setMessage(e.getMessage());
            er.setDeveloperMessage("Permission Request throw an error. See logs for details");

            abortWith500InternalServerError(requestContext, er);
        }
    }
}
