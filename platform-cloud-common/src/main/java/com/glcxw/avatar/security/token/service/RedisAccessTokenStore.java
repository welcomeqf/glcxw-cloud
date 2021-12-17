package com.glcxw.avatar.security.token.service;

import com.alibaba.fastjson.JSONObject;
import com.glcxw.avatar.security.context.Authentication;
import com.glcxw.avatar.security.token.AccessTokenStore;
import net.logstash.logback.encoder.org.apache.commons.lang.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.glcxw.avatar.security.token.service
 * @FileName:       RedisAccessTokenStore.java
 * @ClassName:      RedisAccessTokenStore
 * @Description:    redis版本存储
 * @Author:         wuqiangfu
 * @CreateDate:     2021/8/23 15:27
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/8/23 15:27
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
public class RedisAccessTokenStore implements AccessTokenStore {

   private final RedisTemplate<String, String> redisTemplate;

   public RedisAccessTokenStore (RedisTemplate<String, String> redisTemplate) {
      this.redisTemplate = redisTemplate;
   }

   @Override
   public void storeAuthentication(String key, Authentication authentication, Long expiresIn) {
      String authString = JSONObject.toJSONString(authentication);
      redisTemplate.opsForValue().set(key, authString, expiresIn, TimeUnit.MILLISECONDS);
   }

   @Override
   public Authentication readAuthentication(String key, Class<? extends Authentication> authClass) {
      String authString = redisTemplate.opsForValue().get(key);
      return StringUtils.isNotBlank(authString) ? JSONObject.parseObject(authString, authClass) : null;
   }
}
