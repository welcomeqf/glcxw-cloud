package com.glcxw.avatar.jpush.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.yadea.avatar.message.client.entity
 * @FileName:       PushAllParam.java
 * @ClassName:      PushAllParam
 * @Description:    发送给所有人参数类
 * @Author:         wuqiangfu
 * @CreateDate:     2021/4/20 14:21
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/4/20 14:21
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
@Data
public class PushAllParam implements Serializable {

   /**
    * 推送平台设置
    */
   private String platform;

   /**
    * 推送设备指定
    */
   private String audience;

   /**
    * 通知内容体。是被推送到客户端的内容。与 message 一起二者必须有其一，可以二者并存
    */
   private ContentParam notification;

   /**
    * 消息内容体。是被推送到客户端的内容。与 notification 一起二者必须有其一，可以二者并存
    */
   private ContentParam message;

   /**
    *   推送环境
    */
   private OptionsParam options;

   public PushAllParam(){}

   public PushAllParam(String alert, String msgContent, Boolean environment,String msgType){
      this.notification = new ContentParam(alert, 0,null);
      this.message = new ContentParam(msgContent, 1,msgType);
      this.platform = "all";
      this.audience = "all";
      this.options = new OptionsParam (environment);
   }
}
