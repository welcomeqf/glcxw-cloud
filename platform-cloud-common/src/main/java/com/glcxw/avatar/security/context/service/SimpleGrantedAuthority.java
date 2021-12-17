package com.glcxw.avatar.security.context.service;

import com.glcxw.avatar.security.context.GrantedAuthority;
import org.springframework.util.Assert;

public class SimpleGrantedAuthority implements GrantedAuthority {

    private static final long serialVersionUID = 500L;

    private final String role;

    public SimpleGrantedAuthority(String role) {
        Assert.hasText(role, "A granted authority textual representation is required");
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return this.role;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else {
            return obj instanceof SimpleGrantedAuthority ? this.role.equals(((SimpleGrantedAuthority) obj).role) : false;
        }
    }

    @Override
    public int hashCode() {
        return this.role.hashCode();
    }

    @Override
    public String toString() {
        return this.role;
    }

}
