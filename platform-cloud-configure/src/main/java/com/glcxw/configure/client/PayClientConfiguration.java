package com.glcxw.configure.client;

import com.glcxw.avatar.pay.WxDealData;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.glcxw.configure.client
 * @FileName:       PayClientConfiguration.java
 * @ClassName:      PayClientConfiguration
 * @Description:    支付客户端管理
 * @Author:         wuqiangfu
 * @CreateDate:     2021/9/27 10:25
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/9/27 10:25
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
@Configuration
public class PayClientConfiguration {

   @Bean
   public WxDealData getWxDealData () {
      return new WxDealData ();
   }
}
