package com.glcxw.avatar;

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
 * @Package:        com.glcxw.avatar
 * @FileName:       FileApplication.java
 * @ClassName:      FileApplication
 * @Description:    文件服务启动类
 * @Author:         wuqiangfu
 * @CreateDate:     2021/8/23 17:16
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/8/23 17:16
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
@EnableFeignClients("com.glcxw.avatar.*")
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.glcxw.*.mapper")
@EnableTransactionManagement
@ComponentScan(basePackages = "com.glcxw.*.*")
public class FileApplication {

   private static final Logger logger = LoggerFactory.getLogger(FileApplication.class);

   public static void main(String[] args) {
      SpringApplication.run(FileApplication.class, args);
      logger.info("file service start success");
   }

}
