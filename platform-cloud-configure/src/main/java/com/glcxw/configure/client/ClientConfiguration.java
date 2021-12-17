package com.glcxw.configure.client;

import com.glcxw.avatar.feign.CustomMappingJackson2HttpMessageConverter;
import com.glcxw.avatar.feign.FeignRequestHeard;
import com.glcxw.avatar.common.redis.RedisCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import feign.codec.Decoder;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.glcxw.configure.feign
 * @FileName:       ClientConfiguration.java
 * @ClassName:      ClientConfiguration
 * @Description:    客户端注入管理
 * @Author:         wuqiangfu
 * @CreateDate:     2021/8/24 10:26
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/8/24 10:26
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
@Configuration
public class ClientConfiguration {

   @Autowired
   private RedisTemplate<String,String> redisTemplate;

   @Bean
   public FeignRequestHeard getFeignRequestHeard () {
      return new FeignRequestHeard ();
   }

   @Bean
   public RedisCacheManager getRedisService () {
      return new RedisCacheManager(redisTemplate);
   }

   @Bean
   public Decoder textPlainDecoder() {
      return new SpringDecoder(() -> new HttpMessageConverters(new CustomMappingJackson2HttpMessageConverter()));
   }
}
