package com.glcxw.avatar.common.enums.pay;

import lombok.Getter;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.glcxw.avatar.common.enums.pay
 * @FileName:       AliSignEnums.java
 * @ClassName:      AliSignEnums
 * @Description:    支付宝签约产品与业务类型对应枚举
 * @Author:         wuqiangfu
 * @CreateDate:     2021/9/27 14:27
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/9/27 14:27
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
public enum AliSignEnums {

   /**
    *  充电桩
    */
   CHARGING_PILE (1, "GENERAL_WITHHOLDING_P"),

   ;

   @Getter
   Integer businessType;

   @Getter
   String personalProductCode;

   AliSignEnums(Integer businessType, String personalProductCode) {
      this.businessType = businessType;
      this.personalProductCode = personalProductCode;
   }

   /**
    * wuqiangfu special annotation
    *
    * @return v
    * @Description:  根据业务类型查询产品
    */
   public static String getValue(Integer businessType) {
      AliSignEnums[] aliSignEnums = AliSignEnums.values();
      for (AliSignEnums aliSignEnum : aliSignEnums) {
         if (aliSignEnum.getBusinessType().equals(businessType)) {
            return aliSignEnum.getPersonalProductCode();
         }
      }
      return null;
   }
}
