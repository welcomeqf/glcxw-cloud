package com.glcxw.avatar.feign;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.Collections;
import java.util.List;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.glcxw.configure.client
 * @FileName:       CustomMappingJackson2HttpMessageConverter.java
 * @ClassName:      CustomMappingJackson2HttpMessageConverter
 * @Description:    feign客户端调用类型支持解决
 * @Author:         wuqiangfu
 * @CreateDate:     2021/8/25 9:49
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/8/25 9:49
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
public class CustomMappingJackson2HttpMessageConverter extends MappingJackson2HttpMessageConverter {

   @Override
   public void setSupportedMediaTypes(List<MediaType> supportedMediaTypes) {
      super.setSupportedMediaTypes(Collections.singletonList(MediaType.TEXT_PLAIN));
   }
}
