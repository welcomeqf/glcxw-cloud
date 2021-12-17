package com.glcxw.configure.mybatis;

import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.glcxw.configure.mybatis
 * @FileName:       MybatisPlusPerformanceConfiguration.java
 * @ClassName:      MybatisPlusPerformanceConfiguration
 * @Description:    mybatis-plus性能分析插件
 * @Author:         wuqiangfu
 * @CreateDate:     2021/10/28 16:42
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/10/28 16:42
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
@Configuration
public class MybatisPlusPerformanceConfiguration {

   @Bean
   @Profile({"dev","test"})
   public PerformanceInterceptor performanceInterceptor(){
      PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
      // 设置sql执行的最大时间，如果超过了则不执行
      performanceInterceptor.setMaxTime(2000);
      // 是否格式化
      performanceInterceptor.setFormat(true);
      return performanceInterceptor;
   }
}
