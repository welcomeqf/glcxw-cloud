package com.glcxw.configure.strategy;

import com.glcxw.avatar.strategy.StrategyConcurrent;
import com.glcxw.avatar.strategy.VersionStrategyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.yadea.avatar.configure.strategy
 * @FileName:       VersionStrategyConfiguration.java
 * @ClassName:      VersionStrategyConfiguration
 * @Description:    版本策略配置类
 * @Author:         wuqiangfu
 * @CreateDate:     2021/6/23 15:34
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/6/23 15:34
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
@Configuration
public class VersionStrategyConfiguration {

   @Bean
   public VersionStrategyFilter getVersionStrategyFilter () {
      return new VersionStrategyFilter ();
   }

   @Bean
   public StrategyConcurrent getStrategyConcurrent () {
      return new StrategyConcurrent ();
   }

   @Bean
   public FilterRegistrationBean accessDataPointFilterRegistration(VersionStrategyFilter versionStrategyFilter) {
      FilterRegistrationBean filterRegistration = new FilterRegistrationBean(versionStrategyFilter);
      filterRegistration.setOrder(4);
      filterRegistration.addUrlPatterns("/*");
      filterRegistration.setName(versionStrategyFilter.getClass().getName());
      return filterRegistration;
   }
}
