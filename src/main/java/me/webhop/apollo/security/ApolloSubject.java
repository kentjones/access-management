package me.webhop.apollo.security;

import me.webhop.apollo.exception.AuthorizationException;

import java.util.List;

public interface ApolloSubject
{

    /**
        <p>Returns {@code True} if the Subject is assigned the specified role, false otherwise </p>
     @param roleName - A Role is a named entity that represents a set of behaviors or responsibilities.
     @return true if the Subject is assigned the specific role.
     @since 1.0
    */
    public boolean hasRole(String roleName);
    /**
     <p>Returns {@code True} if the Subject is assigned the specified role, false otherwise </p>
     @param roleNames - A {@code List} of Roles that represents a set of behaviors or responsibilities.
     @return true if the Subject is assigned the specific role.
     @since 1.0
     */
    public boolean hasRoles(List<String> roleNames);

    public void checkRole(String roleName) throws AuthorizationException;
    public void checkRoles(List<String> roleNames) throws AuthorizationException;


}
