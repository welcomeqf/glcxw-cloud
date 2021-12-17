package com.glcxw.avatar.common.constant;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.glcxw.avatar.common.constant
 * @FileName:       ServiceDefinition.java
 * @ClassName:      ServiceDefinition
 * @Description:    微服务定义
 * @Author:         wuqiangfu
 * @CreateDate:     2021/8/23 16:03
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/8/23 16:03
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
public interface ServiceDefinition {

   /**
    *  基础服务
    */
   String PLAT_FROM_BASE = "platform-cloud-base";

   /**
    *  支付中心
    */
   String PLAT_FROM_PAY = "platform-cloud-service-payment";

   /**
    *  用户中心
    */
   String PLAT_FROM_USER = "platform-cloud-service-user";

   /**
    *  订单中心
    */
   String PLAT_FROM_ORDER = "platform-cloud-service-order";

   /**
    *  消息中心
    */
   String PLAT_FROM_MESSAGE = "platform-cloud-service-message";

   /**
    *  文件服务
    */
   String PLAT_FROM_FILE = "platform-cloud-service-file";

   /**
    *  xx中心
    */
   String PLAT_FROM_POWER = "platform-cloud-service-power";

   /**
    *  xx中心
    */
   String PLAT_FROM_ACCESS= "platform-cloud-service-access";

   /**
    *  xx中心
    */
   String PLAT_FROM_SETTLE = "platform-cloud-service-settle";

   /**
    *  监控中心
    */
   String PLAT_FROM_SPRINGBOOT_ADMIN = "platform-cloud-springbootadmin";
}
