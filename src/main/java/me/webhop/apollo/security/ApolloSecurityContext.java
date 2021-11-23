package me.webhop.apollo.security;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.core.SecurityContext;

import java.security.Principal;

public class ApolloSecurityContext implements SecurityContext
{
    private Principal principal;

    ApolloSecurityContext(Principal principal)
    {
        this.principal = principal;
    }
    @Override
    public Principal getUserPrincipal()
    {
        return principal;
    }
    @Override
    public boolean isUserInRole(String role)
    {
        return true;
    }
    @Override
    public boolean isSecure()
    {
        return true;
    }
    @Override
    public String getAuthenticationScheme()
    {
        return "Jwt Scheme";
    }
}
