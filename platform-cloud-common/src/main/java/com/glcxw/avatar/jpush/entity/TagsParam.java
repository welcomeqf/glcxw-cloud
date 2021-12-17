package com.glcxw.avatar.jpush.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * wuqiangfu special annotation
 *
 * @Package:        org.xkw.models
 * @FileName:       TagsParam.java
 * @ClassName:      TagsParam
 * @Description:    标签参数
 * @Author:         wuqiangfu
 * @CreateDate:     2021/4/19 13:44
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/4/19 13:44
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
@Data
public class TagsParam implements Serializable {

   /**
    *  添加的标签
    */
   private List<String> add;

   /**
    *  删除的标签
    */
   private List<String> remove;

   public TagsParam(List<String> add){
      this.add = add;
   }

   /**
    * wuqiangfu special annotation
    *
    * @param
    * @return v
    * @Description:  移除设备
    */
   public TagsParam(List<String> remove, Integer type){
      this.remove = remove;
   }
}
