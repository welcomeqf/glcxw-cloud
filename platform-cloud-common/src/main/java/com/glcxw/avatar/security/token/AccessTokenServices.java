package com.glcxw.avatar.security.token;

import com.glcxw.avatar.security.context.Authentication;

public interface AccessTokenServices {

    /**
     * wuqiangfu special annotation
     *
     * @param  token  token
     * @return v
     * @Description:  通过token得到上下文对象
     */
    Authentication loadAuthentication(String token);

    /**
     * wuqiangfu special annotation
     *
     * @param  authentication  需要保存上下文的对象
     * @return v
     * @Description:  生成token
     */
    String createAccessToken(Authentication authentication);

    /**
     * wuqiangfu special annotation
     *
     * @param  authentication  需要保存上下文对象
     * @param expirationIn  过期时间
     * @return v
     * @Description:  生成token
     */
    String createAccessToken(Authentication authentication, long expirationIn);

}
