package com.glcxw.avatar.common.domain;

import com.glcxw.avatar.common.enums.CodeType;
import lombok.Data;

import java.io.Serializable;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.glcxw.avatar.common.domain
 * @FileName:       ResultEntity.java
 * @ClassName:      ResultEntity
 * @Description:    统一返回给前端数据包包装
 * @Author:         wuqiangfu
 * @CreateDate:     2021/8/20 10:29
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/8/20 10:29
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
@Data
public class ResultEntity<T> implements Serializable {

   /**
    *   状态码
    */
   private Integer code;

   /**
    *  是否成功
    */
   private Boolean success;

   /**
    *  返回的操作消息
    */
   private String message;

   /**
    *   返回的数据结果
    */
   private T result;

   public ResultEntity () {}

   public ResultEntity(Integer code, String message, T result, Boolean success) {
      this.code = code;
      this.message = message;
      this.result = result;
      this.success = success;
   }

   /**
    * wuqiangfu special annotation
    *
    * @param  data  数据
    * @return v
    * @Description:  操作成功
    */
   public static <T> ResultEntity<T> success(T data){
      return new ResultEntity<>(CodeType.SUCCESS.getCode(),CodeType.SUCCESS.getMessage(),data,true);
   }

   /**
    * wuqiangfu special annotation
    *
    * @param code  错误状态码
    * @param message 错误原因
    * @return v
    * @Description:  操作失败
    */
   public static <T> ResultEntity<T> fail(Integer code, String message) {
      return new ResultEntity<>(code,message,null, false);
   }

   /**
    * wuqiangfu special annotation
    *
    * @return v
    * @Description:  操作失败
    */
   public static <T> ResultEntity<T> feignFail() {
      return new ResultEntity<>(CodeType.FEIGN_CONNECT_ERROR.getCode(),CodeType.FEIGN_CONNECT_ERROR.getMessage(),null, false);
   }
}
