package com.glcxw.avatar.jpush.model;

import lombok.Data;

import java.io.Serializable;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.yadea.avatar.jpush
 * @FileName:       PushMessage.java
 * @ClassName:      PushMessage
 * @Description:    推送的实体类
 * @Author:         wuqiangfu
 * @CreateDate:     2021/4/20 15:08
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/4/20 15:08
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
@Data
public class BaseMessage implements Serializable {

   /**
    * 消息内容
    */
   private String content;

   /**
    *  消息类型
    */
   private Integer type;

   public BaseMessage (){}

   /**
    * wuqiangfu special annotation
    *
    * @return v
    * @Description:  消息发送初始化
    */
   public BaseMessage (Integer type, String content) {
      this.type = type;
      this.content = content;
   }
}
