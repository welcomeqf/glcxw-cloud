package com.glcxw.avatar.jpush.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * wuqiangfu special annotation
 *
 * @Package:        org.xkw.models
 * @FileName:       PushParam.java
 * @ClassName:      PushParam
 * @Description:    推送参数
 * @Author:         wuqiangfu
 * @CreateDate:     2021/4/19 13:42
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/4/19 13:42
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
@Data
public class PushParam implements Serializable {

   /**
    *  支持 add, remove 或者空字符串。当 tags 参数为空字符串的时候，表示清空所有的 tags
    */
   private TagsParam tags;

   /**
    *  更新设备的别名属性；当别名为空串时，删除指定设备的别名
    */
   private String alias;

   /**
    * 设备关联的手机号码；当 mobile 为空串时，表示清空设备关联的手机号码
    */
   private String mobile;

   public PushParam() {
   }

   public PushParam(String alias, List<String> add) {
      this.tags = new TagsParam (add);
      this.alias = alias;
   }

   public PushParam(List<String> remove) {
      this.tags = new TagsParam (remove, 1);
      this.alias = "";
   }
}
