package com.glcxw.avatar.jpush.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * wuqiangfu special annotation
 *
 * @Package:        org.xkw.models
 * @FileName:       ContentParam.java
 * @ClassName:      ContentParam
 * @Description:    消息内容参数
 * @Author:         wuqiangfu
 * @CreateDate:     2021/4/19 17:27
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/4/19 17:27
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
@Data
public class ContentParam implements Serializable {

   /**
    *  弹出框消息
    */
   private String alert;

   /**
    * 消息内容
    */
   private String msg_content;

   /**
    *  类型
    */
   private String content_type;

   public ContentParam(){}

   public ContentParam(String msg, Integer type, String msgType){
      if (type == 0) {
         this.alert = msg;
      } else {
         this.msg_content = msg;
         this.content_type = msgType;
      }
   }
}
