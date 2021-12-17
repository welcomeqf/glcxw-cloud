package com.glcxw.configure.security;

import com.glcxw.avatar.security.filter.AccessAuthFilter;
import com.glcxw.avatar.security.filter.BearerAuthenticationFilter;
import com.glcxw.avatar.security.filter.SecurityPretreatmentFilter;
import com.glcxw.avatar.security.token.AccessTokenServices;
import com.glcxw.avatar.security.token.AccessTokenStore;
import com.glcxw.avatar.security.token.service.DefaultAccessTokenServices;
import com.glcxw.avatar.security.token.service.InMemoryAccessTokenStore;
import com.glcxw.avatar.security.token.service.RedisAccessTokenStore;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.glcxw.configure.security
 * @FileName:       SecurityConfigution.java
 * @ClassName:      SecurityConfigution
 * @Description:    security配置
 * @Author:         wuqiangfu
 * @CreateDate:     2021/8/20 18:23
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/8/20 18:23
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
@Configuration
public class SecurityConfiguration {

   final SecurityPathsProperty securityPathsProperty;

   final RedisTemplate<String, String> redisTemplate;

   public SecurityConfiguration(SecurityPathsProperty securityPathsProperty, RedisTemplate<String, String> redisTemplate) {
      this.securityPathsProperty = securityPathsProperty;
      this.redisTemplate = redisTemplate;
   }

   @Bean
   public RedisAccessTokenStore getRedisAccessTokenStore () {
      return new RedisAccessTokenStore (redisTemplate);
   }

   @Bean
   public AccessTokenServices tokenServices(AccessTokenStore accessTokenStore) {
      return new DefaultAccessTokenServices(accessTokenStore);
   }

   @Bean
   public SecurityPretreatmentFilter pretreatmentFilter() {
      return new SecurityPretreatmentFilter();
   }

   @Bean
   public BearerAuthenticationFilter authenticationFilter(AccessTokenServices tokenServices) {
      return new BearerAuthenticationFilter(tokenServices);
   }

   @Bean
   public AccessAuthFilter accessInterceptorFilter(SecurityPathsProperty securityPathsProperty) {
      return new AccessAuthFilter(securityPathsProperty.buildSecurityRequestMatcher());
   }

   @Bean
   public FilterRegistrationBean pretreatmentFilterRegistration(SecurityPretreatmentFilter pretreatmentFilter) {
      FilterRegistrationBean filterRegistration = new FilterRegistrationBean(pretreatmentFilter);
      filterRegistration.setOrder(1);
      filterRegistration.addUrlPatterns("/*");
      filterRegistration.setName(pretreatmentFilter.getClass().getName());
      return filterRegistration;
   }

   @Bean
   public FilterRegistrationBean authenticationFilterRegistration(BearerAuthenticationFilter authenticationFilter) {
      FilterRegistrationBean filterRegistration = new FilterRegistrationBean(authenticationFilter);
      filterRegistration.setOrder(2);
      filterRegistration.addUrlPatterns("/*");
      filterRegistration.setName(authenticationFilter.getClass().getName());
      return filterRegistration;
   }

   @Bean
   public FilterRegistrationBean accessInterceptorFilterRegistration(AccessAuthFilter accessInterceptorFilter) {
      FilterRegistrationBean filterRegistration = new FilterRegistrationBean(accessInterceptorFilter);
      filterRegistration.setOrder(3);
      filterRegistration.addUrlPatterns("/*");
      filterRegistration.setName(accessInterceptorFilter.getClass().getName());
      return filterRegistration;
   }
}
