package com.glcxw.avatar.common.enums;

import lombok.Getter;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.yadea.avatar.common.enums
 * @FileName:       RabbitEnums.java
 * @ClassName:      RabbitEnums
 * @Description:    配置需要轮询的类型
 * @Author:         wuqiangfu
 * @CreateDate:     2021/5/19 14:25
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/5/19 14:25
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
public enum PollingServiceEnums {

   /**
    *  通知（具体业务）
    */
   NOTICE_SERVICE_1_MESSAGE (1, 7),

   /**
    *   通知（具体业务）
    */
   NOTICE_SERVICE_2_MESSAGE (2, 7),
   ;

   @Getter
   Integer key;

   @Getter
   Integer count;

   PollingServiceEnums(Integer key, Integer count) {
      this.key = key;
      this.count = count;
   }

   /**
    * wuqiangfu special annotation
    *
    * @return v
    * @Description:  根据key查询数量
    */
   public static Integer getValue(Integer key) {
      PollingServiceEnums[] rabbitEnums = PollingServiceEnums.values();
      for (int i = 0; i < rabbitEnums.length; i++) {
         if (rabbitEnums[i].getKey().equals(key)) {
            return rabbitEnums[i].getCount();
         }
      }
      return 3;
   }
}
