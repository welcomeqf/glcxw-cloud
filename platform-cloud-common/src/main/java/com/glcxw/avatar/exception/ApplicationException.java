package com.glcxw.avatar.exception;

import com.glcxw.avatar.common.enums.CodeType;
import lombok.Data;

import java.io.Serializable;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.glcxw.avatar.exception
 * @FileName:       ApplicationException.java
 * @ClassName:      ApplicationException
 * @Description:    统一异常抛出
 * @Author:         wuqiangfu
 * @CreateDate:     2021/8/20 13:36
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/8/20 13:36
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
@Data
public class ApplicationException extends RuntimeException implements Serializable {

   /**
    *  code码
    */
   private Integer code;

   /**
    *  错误原因
    */
   private String message;

   /**
    *  http状态码
    */
   private Integer status;

   public ApplicationException () {
      super();
   }

   /**
    * wuqiangfu special annotation
    *
    * @param codeType 常规异常列举
    * @return v
    * @Description:  默认异常返回
    */
   public ApplicationException (CodeType codeType) {
      this.code = codeType.getCode();
      this.message = codeType.getMessage();
      this.status = codeType.getStatus();
   }

   /**
    * wuqiangfu special annotation
    *
    * @param  codeType 常规异常列举
    * @param message  自定义定义异常内容
    * @return v
    * @Description:  自定义异常返回
    */
   public ApplicationException (CodeType codeType, String message) {
      this.code = codeType.getCode();
      this.message = message;
      this.status = codeType.getStatus();
   }

   /**
    * wuqiangfu special annotation
    *
    * @param  code  自定义状态码
    * @param message 自定义异常内容
    * @return v
    * @Description:  自定义异常返回
    */
   public ApplicationException (Integer code, String message) {
      this.code = code;
      this.message = message;
      this.status = 500;
   }

   /**
    * wuqiangfu special annotation
    *
    * @param  code  自定义状态码
    * @param message 自定义异常内容
    * @param status http状态码
    * @return v
    * @Description:  自定义异常返回
    */
   public ApplicationException (Integer code, String message, Integer status) {
      this.code = code;
      this.message = message;
      this.status = status;
   }

}
