package com.glcxw.avatar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.glcxw.avatar
 * @FileName:       PlatformGatewayApplication.java
 * @ClassName:      PlatformGatewayApplication
 * @Description:    网关启动类
 * @Author:         wuqiangfu
 * @CreateDate:     2021/8/19 11:13
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/8/19 11:13
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
@EnableDiscoveryClient
@SpringBootApplication
public class GatewayApplication {

   public static void main(String[] args) {
      SpringApplication.run(GatewayApplication.class, args);
   }

}
