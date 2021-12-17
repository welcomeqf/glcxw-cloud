package com.glcxw.avatar.exception.handle;

import com.glcxw.avatar.common.enums.CodeType;
import com.glcxw.avatar.exception.ApplicationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.glcxw.avatar.exception.handle
 * @FileName:       ApplicationAdviceHandle.java
 * @ClassName:      ApplicationAdviceHandle
 * @Description:    全局异常包装处理
 * @Author:         wuqiangfu
 * @CreateDate:     2021/8/20 13:53
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/8/20 13:53
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
@RestControllerAdvice
public class ApplicationAdviceHandle extends ResponseEntityExceptionHandler {

   /**
    * wuqiangfu special annotation
    *
    * @param  e  自定义异常
    * @param response  响应对象
    * @return v
    * @Description:  自定义返回异常
    */
   @ExceptionHandler(value = ApplicationException.class)
   public ApplicationException applicationExceptionHandle (final ApplicationException e, HttpServletResponse response) {
      response.setStatus(e.getStatus());
      response.setHeader("Access-Control-Allow-Origin", "*");
      response.setHeader("Access-Control-Allow-Methods", "*");
      response.setHeader("Access-Control-Max-Age", "3600");
      response.setHeader("Access-Control-Allow-Headers",
            "Origin, X-CSRF-TOKEN, X-Requested-With, Content-Type, Accept");
      return e;
   }

   /**
    * wuqiangfu special annotation
    *
    * @param  e  自定义异常
    * @param response  响应对象
    * @return v
    * @Description:  其他异常
    */
   @ExceptionHandler(value = Exception.class)
   public ApplicationException exceptionHandle (final ApplicationException e, HttpServletResponse response) {
      response.setStatus(CodeType.UNKNOWN_ERROR.getStatus());
      e.printStackTrace();
      return new ApplicationException(CodeType.UNKNOWN_ERROR);
   }
}
