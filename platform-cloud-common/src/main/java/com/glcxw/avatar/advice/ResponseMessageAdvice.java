package com.glcxw.avatar.advice;

import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.glcxw.avatar.advice
 * @FileName:       WebAdvice.java
 * @ClassName:      WebAdvice
 * @Description:    重写消息转换器
 * @Author:         wuqiangfu
 * @CreateDate:     2021/9/16 21:02
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/9/16 21:02
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
public class ResponseMessageAdvice implements WebMvcConfigurer {

   @Override
   public void configureMessageConverters(@NotNull List<HttpMessageConverter<?>> converters) {
      converters.add(0, new MappingJackson2HttpMessageConverter());
   }
}
