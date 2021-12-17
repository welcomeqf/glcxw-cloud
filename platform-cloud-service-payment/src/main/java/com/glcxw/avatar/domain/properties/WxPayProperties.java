package com.glcxw.avatar.domain.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.master.pay.domain
 * @FileName:       WxPayProperties.java
 * @ClassName:      WxPayProperties
 * @Description:    微信支付参数配置
 * @Author:         wuqiangfu
 * @CreateDate:     2021/9/6 14:15
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/9/6 14:15
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "pay.wx")
public class WxPayProperties {

   /**
    *  微信支付AppId
    */
   private String appId;

   /**
    *  微信支付商户Id
    */
   private String mchId;

   /**
    *  微信支付私钥
    */
   private String privateKey;

   /**
    *  微信证书
    */
   private String certUrl;

   /**
    *  微信支付回调接口
    */
   private String wxNotifyUrl;

   /**
    *  微信退款回调接口
    */
   private String wxRefundNotifyUrl;

   /**
    *  微信支付接口
    */
   private String payApi;

   /**
    *  查询支付订单接口
    */
   private String queryPayApi;

   /**
    *  关闭订单接口
    *  说明: 当用户微信支付订单超时, 需调用此接口关闭订单防止用户重复支付
    */
   private String closeOrderApi;

   /**
    *  退款接口
    */
   private String refundApi;

   /**
    *  查询退款接口
    */
   private String queryRefundApi;
}
