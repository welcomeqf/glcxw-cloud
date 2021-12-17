package com.glcxw.avatar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.glcxw.avatar.config
 * @FileName:       CorsConfig.java
 * @ClassName:      CorsConfig
 * @Description:    跨域配置
 * @Author:         wuqiangfu
 * @CreateDate:     2021/8/24 13:50
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/8/24 13:50
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
@Configuration
public class CorsConfig {

   @Bean
   public CorsWebFilter corsWebFilter(){
      UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

      CorsConfiguration corsConfiguration = new CorsConfiguration();

      corsConfiguration.addAllowedHeader("*");
      corsConfiguration.addAllowedMethod("*");
      corsConfiguration.addAllowedOrigin("*");
      corsConfiguration.setAllowCredentials(true);

      source.registerCorsConfiguration("/**",corsConfiguration);
      return new CorsWebFilter(source);
   }
}
