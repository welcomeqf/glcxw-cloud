package com.glcxw.configure.advice;

import com.glcxw.avatar.advice.ResponseMessageAdvice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.glcxw.configure.advice
 * @FileName:       ResponseAdviceConfiguration.java
 * @ClassName:      ResponseAdviceConfiguration
 * @Description:    重写消息转换器配置
 * @Author:         wuqiangfu
 * @CreateDate:     2021/9/16 21:42
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/9/16 21:42
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
@Configuration
public class ResponseAdviceConfiguration {

   @Bean
   public ResponseMessageAdvice getResponseMessageAdvice () {
      return new ResponseMessageAdvice ();
   }
}
