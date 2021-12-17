package com.glcxw.configure.serialize;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.StandardCharsets;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.glcxw.configure.serialize
 * @FileName:       JsonFormatSerialize.java
 * @ClassName:      JsonFormatSerialize
 * @Description:    修改SpringBoot默认序列化方式Jackson->fastJson
 * @Description:    (有点小冲突, 暂时放弃修改)
 * @Author:         wuqiangfu
 * @CreateDate:     2021/9/17 17:02
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/9/17 17:02
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
//@Configuration
public class JsonFormatSerialize {

   @Bean
   public HttpMessageConverters fastJsonHttpMessageConverters() {
      //1、定义一个convert转换消息的对象
      FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
      FastJsonConfig fastJsonConfig = new FastJsonConfig();
      SerializerFeature[] serializerFeatures = new SerializerFeature[]{
            //是否输出为null的字段,若为null 则显示该字段
            //SerializerFeature.WriteMapNullValue,
            //数值字段如果为null，则输出为0
            SerializerFeature.WriteNullNumberAsZero,
            //List字段如果为null,输出为[],而非null
            SerializerFeature.WriteNullListAsEmpty,
            //字符类型字段如果为null,输出为"",而非null
            SerializerFeature.WriteNullStringAsEmpty,
            //Boolean字段如果为null,输出为false,而非null
            //SerializerFeature.WriteNullBooleanAsFalse,
            //Date的日期转换器
            SerializerFeature.WriteDateUseDateFormat,
            SerializerFeature.DisableCircularReferenceDetect,
      };
      fastJsonConfig.setSerializerFeatures(serializerFeatures);
      fastJsonConfig.setCharset(StandardCharsets.UTF_8);
      fastConverter.setFastJsonConfig(fastJsonConfig);
      return new HttpMessageConverters(fastConverter);
   }
}
