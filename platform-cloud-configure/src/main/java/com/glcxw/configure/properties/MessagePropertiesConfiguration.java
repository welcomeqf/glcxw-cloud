package com.glcxw.configure.properties;

import com.glcxw.avatar.httpclient.HttpClient;
import com.glcxw.avatar.jpush.client.PushClient;
import com.glcxw.avatar.jpush.model.MessageProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.glcxw.configure.properties
 * @FileName:       MessagePropertiesConfiguration.java
 * @ClassName:      MessagePropertiesConfiguration
 * @Description:    激光消息配置管理
 * @Author:         wuqiangfu
 * @CreateDate:     2021/9/21 16:35
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/9/21 16:35
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
@Configuration
@EnableConfigurationProperties(MessageProperties.class)
public class MessagePropertiesConfiguration {

   private final HttpClient httpClient;

   private final MessageProperties messageProperties;

   public MessagePropertiesConfiguration(HttpClient httpClient, MessageProperties messageProperties) {
      this.httpClient = httpClient;
      this.messageProperties = messageProperties;
   }

   @Bean
   public MessageProperties getMessageProperties () {
      return new MessageProperties();
   }

   @Bean
   public PushClient getPushClient () {
      return new PushClient (httpClient, messageProperties);
   }
}
