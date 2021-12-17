package com.glcxw.avatar.jpush.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * wuqiangfu special annotation
 *
 * @Package:        org.xkw.models
 * @FileName:       OptionsParam.java
 * @ClassName:      OptionsParam
 * @Description:    推送参数
 * @Author:         wuqiangfu
 * @CreateDate:     2021/4/20 9:57
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/4/20 9:57
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
@Data
public class OptionsParam implements Serializable {

   /**
    *   推送环境 默认生产环境
    *   false- 开发环境
    */
   private Boolean apns_production;

   public OptionsParam(Boolean apns_production) {
      this.apns_production = apns_production;
   }
}
