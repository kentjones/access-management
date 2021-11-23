package me.webhop.apollo.security;

import javax.security.auth.Subject;
import java.security.Principal;

public class ApolloPrincipal implements Principal {
    private String name;

    ApolloPrincipal(String name)
    {
        this.name = name;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean implies(Subject subject)
    {
        return Principal.super.implies(subject);
    }
}
