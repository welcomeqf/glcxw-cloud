package com.glcxw.avatar.domain.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.master.pay.domain
 * @FileName:       AliPayProperties.java
 * @ClassName:      AliPayProperties
 * @Description:    阿里支付宝配置
 * @Author:         wuqiangfu
 * @CreateDate:     2021/9/11 9:39
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/9/11 9:39
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "pay.ali")
public class AliPayProperties {

   /**
    *  支付宝支付请求路径
    */
   private String url;

   /**
    *  appId
    */
   private String appId;

   /**
    *  商户私钥
    */
   private String privateKey;

   /**
    *  支付宝公钥
    */
   private String publicKey;

   /**
    *  支付宝支付回调
    */
   private String notifyServerUrl;

   /**
    *  支付宝签约回调
    */
   private String signNotifyServerUrl;

   /**
    *  支付宝解签回调
    */
   private String unSignNotifyServerUrl;
}
