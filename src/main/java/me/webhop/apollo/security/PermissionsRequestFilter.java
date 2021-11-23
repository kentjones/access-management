package me.webhop.apollo.security;

import jakarta.annotation.Priority;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ResourceContext;
import jakarta.ws.rs.container.ResourceInfo;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.ext.Provider;

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

                    abortWith403Forbidden(requestContext);
                }

                String token = requestContext.getHeaderString(AuthorizationToken);
                if(StringUtils.isEmpty(token)){
                    abortWith401Unauthorized(requestContext);
                }

            }


        } catch (Exception e) {

            abortWith403Forbidden(requestContext);
        }
    }
}
