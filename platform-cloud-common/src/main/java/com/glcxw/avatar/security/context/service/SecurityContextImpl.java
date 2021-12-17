package com.glcxw.avatar.security.context.service;

import com.glcxw.avatar.security.context.Authentication;
import com.glcxw.avatar.security.context.SecurityContext;

public class SecurityContextImpl implements SecurityContext {

    private static final long serialVersionUID = 500L;

    private Authentication authentication;

    public SecurityContextImpl() {
    }

    public SecurityContextImpl(Authentication authentication) {
        this.authentication = authentication;
    }

    @Override
    public Authentication getAuthentication() {
        return this.authentication;
    }

    @Override
    public void setAuthentication(Authentication authentication) {
        this.authentication = authentication;
    }

    @Override
    public int hashCode() {
        return this.authentication == null ? -1 : this.authentication.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SecurityContextImpl) {
            SecurityContextImpl test = (SecurityContextImpl) obj;
            if (this.getAuthentication() == null && test.getAuthentication() == null) {
                return true;
            }

            if (this.getAuthentication() != null && test.getAuthentication() != null && this.getAuthentication().equals(test.getAuthentication())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        if (this.authentication == null) {
            sb.append(": Null authentication");
        } else {
            sb.append(": Authentication: ").append(this.authentication);
        }

        return sb.toString();
    }
}
