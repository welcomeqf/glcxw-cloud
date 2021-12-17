package com.glcxw.configure.client;

import com.glcxw.avatar.common.polling.PollingAlgorithm;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.glcxw.configure.client
 * @FileName:       PollingAlgorithmConfiguration.java
 * @ClassName:      PollingAlgorithmConfiguration
 * @Description:    简单轮询客户端配置管理
 * @Author:         wuqiangfu
 * @CreateDate:     2021/9/21 15:53
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/9/21 15:53
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
@Configuration
public class PollingAlgorithmConfiguration {

   @Bean
   public PollingAlgorithm getPollingAlgorithm () {
      return new PollingAlgorithm ();
   }
}
