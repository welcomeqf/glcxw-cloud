package com.glcxw.avatar.jpush.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * wuqiangfu special annotation
 *
 * @Package:        org.xkw.models
 * @FileName:       SchedulePushParam.java
 * @ClassName:      SchedulePushParam
 * @Description:    定时任务推送消息
 * @Author:         wuqiangfu
 * @CreateDate:     2021/4/19 17:23
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/4/19 17:23
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
@Data
public class SchedulePushParam implements Serializable {

   /**
    * 推送平台设置
    */
   private String platform;

   /**
    * 推送设备指定
    */
   private TagParam audience;

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

   public SchedulePushParam(){}

   /**
    * wuqiangfu special annotation
    *
    * @param type 0-标签  1-别名发送
    * @return v
    * @Description:  装配消息参数
    */
   public SchedulePushParam(String alert, String msgContent, Boolean environment, List<String> values, int type, String mstType){
      this.notification = new ContentParam(alert, 0,null);
      this.message = new ContentParam(msgContent, 1, mstType);
      this.platform = "all";
      this.audience = new TagParam(values, type);
      this.options = new OptionsParam (environment);
   }
}
