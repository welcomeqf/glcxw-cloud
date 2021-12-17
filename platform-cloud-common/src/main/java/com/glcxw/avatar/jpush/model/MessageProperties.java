package com.glcxw.avatar.jpush.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.glcxw.avatar.jpush.model
 * @FileName:       MessageProperties.java
 * @ClassName:      MessageProperties
 * @Description:    极光消息配置
 * @Author:         wuqiangfu
 * @CreateDate:     2021/9/21 16:03
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/9/21 16:03
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "push")
public class MessageProperties {

   /**
    *  极光消息key
    */
   private String appKey;

   /**
    *  极光消息私钥
    */
   private String appSecret;

   /**
    * 基础请求地址
    */
   private String baseUrl;

   /**
    *  发送定时消息地址
    */
   private String scheduleUrl;

   /**
    *  发送实时消息的地址
    */
   private String pushUrl;

   /**
    *  发送设置标签和别名地址
    */
   private String devicesUrl;

   /**
    *  是否调用极光生产环境
    *  测试阶段, 应该设置为 false
    *  生产阶段, 应该设置为 true
    */
   private Boolean environment;
}
