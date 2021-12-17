package com.glcxw.avatar.security.context;

import java.io.Serializable;

public interface GrantedAuthority extends Serializable {

    /**
     * wuqiangfu special annotation
     *
     * @return v
     * @Description:  角色获取
     */
    String getAuthority();

}
