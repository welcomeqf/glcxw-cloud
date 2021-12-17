package com.glcxw.avatar.common.enums;

import lombok.Getter;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.glcxw.avatar.common.enums
 * @FileName:       CodeType.java
 * @ClassName:      CodeType
 * @Description:    code列举
 * @Author:         wuqiangfu
 * @CreateDate:     2021/8/20 10:35
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/8/20 10:35
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
public enum CodeType {

   /**
    * 成功
    */
   SUCCESS(0, "操作成功", 200),

   /**
    * 未知错误
    */
   UNKNOWN_ERROR(999, "未知错误", 500),

   /**
    * 身份认证错误
    */
   AUTHENTICATION_ERROR(401, "身份认证错误", 401),

   /**
    * 账号或密码错误
    */
   LOGIN_ERROR(1001, "账号或密码错误", 500),

   /**
    * 参数错误
    */
   PARAMETER_ERROR(1002, "参数错误", 500),

   /**
    * 资源未找到
    */
   RESOURCES_NOT_FIND(1003, "资源未找到", 500),

   /**
    * 资源已存在
    */
   RESOURCES_EXISTING(1004, "资源已存在", 500),

   /**
    * 验证码错误
    */
   SMS_CODE_ERROR(1005, "验证码错误", 500),

   /**
    * 业务异常
    */
   SERVICE_ERROR(1006, "业务异常", 500),

   /**
    * feign 调用异常
    */
   FEIGN_CONNECT_ERROR(1007, "网络忙，请稍后再试", 500),

   /**
    * 解码失败
    */
   DECODING_ERROR(1008,"解码失败", 500),

   /**
    * 数据库操作失败
    */
   DATABASE_ERROR(1009, "数据库操作失败", 500);
   ;

   /**
    *   状态码
    */
   @Getter
   private Integer code;

   /**
    * 操作消息
    */
   @Getter
   private String message;

   /**
    *  http状态码
    */
   @Getter
   private Integer status;

   CodeType(int code, String message, Integer status) {
      this.code = code;
      this.message = message;
      this.status = status;
   }
}
