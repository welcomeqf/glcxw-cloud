package com.glcxw.base;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.glcxw.base
 * @FileName:       PlatformBaseApplication.java
 * @ClassName:      PlatformBaseApplication
 * @Description:    基础模块启动类
 * @Author:         wuqiangfu
 * @CreateDate:     2021/8/19 11:12
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/8/19 11:12
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
@EnableFeignClients("com.glcxw.avatar.*")
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.glcxw.*.mapper")
@EnableTransactionManagement
@ComponentScan(basePackages = "com.glcxw.*.*")
public class BaseApplication {

   private static final Logger logger = LoggerFactory.getLogger(BaseApplication.class);

   public static void main(String[] args) {
      SpringApplication.run(BaseApplication.class, args);
      logger.info("base service start success");
   }
}
