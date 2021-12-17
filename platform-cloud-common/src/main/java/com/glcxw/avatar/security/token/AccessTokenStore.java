package com.glcxw.avatar.security.token;

import com.glcxw.avatar.security.context.Authentication;

public interface AccessTokenStore {

    /**
     * wuqiangfu special annotation
     *
     * @return v
     * @Description:  保存authentication
     */
    void storeAuthentication(String key, Authentication authentication, Long expiresIn);

    /**
     * wuqiangfu special annotation
     *
     * @return v
     * @Description:  取authentication信息并移除保存的信息
     */
    Authentication readAuthentication(String key, Class<? extends Authentication> authClass);

}
