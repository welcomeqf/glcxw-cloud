package com.glcxw.avatar.exception.handle;

import com.glcxw.avatar.common.constant.SwaggerConstant;
import com.glcxw.avatar.common.domain.ResultEntity;
import com.glcxw.avatar.exception.ApplicationException;
import com.glcxw.avatar.exception.anntation.IgnoreResponseAdvice;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import java.util.Objects;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.glcxw.avatar.exception.handle
 * @FileName:       GlobalResponseHandle.java
 * @ClassName:      GlobalResponseHandle
 * @Description:    全局统一返回数据处理
 * @Author:         wuqiangfu
 * @CreateDate:     2021/8/20 14:00
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/8/20 14:00
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
@RestControllerAdvice
public class GlobalResponseHandle implements ResponseBodyAdvice {

   @Override
   public boolean supports(MethodParameter methodParameter, Class clazz) {
      if (Objects.requireNonNull(methodParameter.getMethod()).isAnnotationPresent(IgnoreResponseAdvice.class)
      || clazz.isAnnotationPresent(IgnoreResponseAdvice.class)) {
         return false;
      }
      if (methodParameter.getMember().getName().equals(SwaggerConstant.error)
            || methodParameter.getMember().getName().equals(SwaggerConstant.uiConfiguration)
            || methodParameter.getMember().getName().equals(SwaggerConstant.securityConfiguration)
            || methodParameter.getMember().getName().equals(SwaggerConstant.swaggerResources)
            || methodParameter.getMember().getName().equals(SwaggerConstant.getDocumentation)) {
         return false;
      }
      return true;
   }

   @Override
   public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class clazz, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
      if (o instanceof ApplicationException) {
         ApplicationException exception = (ApplicationException) o;
         return ResultEntity.fail(exception.getCode(), exception.getMessage());
      }
      return ResultEntity.success(o);
   }
}
