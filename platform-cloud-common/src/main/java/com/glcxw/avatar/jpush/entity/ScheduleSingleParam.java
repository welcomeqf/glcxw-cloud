package com.glcxw.avatar.jpush.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * wuqiangfu special annotation
 *
 * @Package:        org.xkw.models
 * @FileName:       ScheduleSingleParam.java
 * @ClassName:      ScheduleSingleParam
 * @Description:    定时任务参数
 * @Author:         wuqiangfu
 * @CreateDate:     2021/4/19 17:20
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/4/19 17:20
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
@Data
public class ScheduleSingleParam implements Serializable {

   /**
    *   定时
    */
   private TimeParam single;

   public ScheduleSingleParam(){}

   public ScheduleSingleParam(String time){
      this.single = new TimeParam (time);
   }
}
