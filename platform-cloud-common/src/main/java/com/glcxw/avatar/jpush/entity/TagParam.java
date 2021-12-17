package com.glcxw.avatar.jpush.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * wuqiangfu special annotation
 *
 * @Package:        org.xkw.models
 * @FileName:       TagParam.java
 * @ClassName:      TagParam
 * @Description:    标签参数
 * @Author:         wuqiangfu
 * @CreateDate:     2021/4/20 13:58
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/4/20 13:58
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
@Data
public class TagParam implements Serializable {

   /**
    *  标签集合
    */
   private List<String> tag;

   /**
    *  别名
    */
   private List<String> alias;


   public TagParam (List<String> values, Integer type) {
      if (type == 0) {
         this.tag = values;
      } else {
         this.alias = values;
      }
   }
}
