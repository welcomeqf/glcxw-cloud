package com.glcxw.avatar.jpush.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * wuqiangfu special annotation
 *
 * @Package:        org.xkw.models
 * @FileName:       TimeParam.java
 * @ClassName:      TimeParam
 * @Description:    时间参数
 * @Author:         wuqiangfu
 * @CreateDate:     2021/4/19 17:56
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/4/19 17:56
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
@Data
public class TimeParam implements Serializable {

   /**
    *  日期
    */
   private String time;

   public TimeParam(){}

   public TimeParam(String time){
      this.time = time;
   }
}
