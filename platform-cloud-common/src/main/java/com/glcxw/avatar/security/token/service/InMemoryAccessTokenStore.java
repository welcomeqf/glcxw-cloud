package com.glcxw.avatar.security.token.service;

import com.alibaba.fastjson.JSONObject;
import com.glcxw.avatar.security.context.Authentication;
import com.glcxw.avatar.security.token.AccessTokenStore;
import net.logstash.logback.encoder.org.apache.commons.lang.StringUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryAccessTokenStore implements AccessTokenStore {

    private final Map<String, Long> expiryStore = new ConcurrentHashMap<>();

    private final Map<String, String> authenticationStore = new ConcurrentHashMap<>();

    @Override
    public void storeAuthentication(String token, Authentication authentication, Long expiresIn) {
        expiryStore.put(token, System.currentTimeMillis() + expiresIn);
        authenticationStore.put(token, JSONObject.toJSONString(authentication));
    }

    @Override
    public Authentication readAuthentication(String token, Class<? extends Authentication> authClass) {
        Long expiresIn = expiryStore.get(token);
        if (expiresIn == null) {
            return null;
        }
        if (System.currentTimeMillis() >= expiresIn) {
            expiryStore.remove(token);
            authenticationStore.remove(token);
            return null;
        } else {
            String authString = authenticationStore.get(token);
            return StringUtils.isNotBlank(authString) ? JSONObject.parseObject(authString, authClass) : null;
        }
    }
}
