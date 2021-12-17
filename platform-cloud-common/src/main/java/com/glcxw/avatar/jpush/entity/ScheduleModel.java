package com.glcxw.avatar.jpush.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * wuqiangfu special annotation
 *
 * @Package:        org.xkw.models
 * @FileName:       SchesuleModel.java
 * @ClassName:      SchesuleModel
 * @Description:    定时任务model
 * @Author:         wuqiangfu
 * @CreateDate:     2021/4/19 17:17
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/4/19 17:17
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
@Data
public class ScheduleModel implements Serializable {

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
   private SchedulePushParam push;

   public ScheduleModel(String name, Boolean environment, String time, String alert, String msgContent, List<String> tags, int type, String msgType) {
      this.name = name;
      this.enabled = true;
      this.trigger = new ScheduleSingleParam(time);
      this.push = new SchedulePushParam (alert,msgContent,environment,tags, type, msgType);
   }

   /**
    * wuqiangfu special annotation
    *
    * @return v
    * @Description:  修改时间
    */
   public ScheduleModel(String time) {
      this.trigger = new ScheduleSingleParam(time);
   }

}
