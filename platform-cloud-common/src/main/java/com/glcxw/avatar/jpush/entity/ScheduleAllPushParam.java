package com.glcxw.avatar.jpush.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.yadea.avatar.message.client.entity
 * @FileName:       ScheduleAllPushParam.java
 * @ClassName:      ScheduleAllPushParam
 * @Description:    定时发送给所有人参数
 * @Author:         wuqiangfu
 * @CreateDate:     2021/4/20 14:23
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/4/20 14:23
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
@Data
public class ScheduleAllPushParam implements Serializable {

   /**
    * 定时任务设备名称
    */
   private String name;

   /**
    *  创建时候必须为true
    */
   private Boolean enabled;

   /**
    * 表示 schedule 任务的触发条件，当前只支持定时任务（single）与定期任务（periodical）
    */
   private ScheduleSingleParam trigger;

   /**
    *  定时普通推送，参考 push api 中各个字段。
    */
   private PushAllParam push;

   public ScheduleAllPushParam(String name, Boolean environment, String time, String alert, String msgContent, String msgType) {
      this.name = name;
      this.enabled = true;
      this.trigger = new ScheduleSingleParam(time);
      this.push = new PushAllParam (alert,msgContent,environment,msgType);
   }
}
