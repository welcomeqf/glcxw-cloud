package com.glcxw.avatar.security.context;

import java.io.Serializable;
import java.util.Collection;

public interface Authentication extends Serializable {

    /**
     * wuqiangfu special annotation
     *
     * @return v
     * @Description:  取得token里面的对象
     */
    Object getDetails();

    Object getPrincipal();

    boolean isAuthenticated();

    void setAuthenticated(boolean authenticated);

    Collection<? extends GrantedAuthority> getAuthorities();

}
