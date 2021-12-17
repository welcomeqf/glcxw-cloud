package com.glcxw.avatar.exception.aop;

import com.alibaba.fastjson.JSONObject;
import com.glcxw.avatar.common.domain.ResultEntity;
import com.glcxw.avatar.common.enums.CodeType;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.glcxw.avatar.exception.aop
 * @FileName:       ControllerAfter.java
 * @ClassName:      ControllerAfter
 * @Description:    控制层后置增强---> 针对返回String数据
 * @Author:         wuqiangfu
 * @CreateDate:     2021/8/23 10:58
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/8/23 10:58
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
//@Aspect
//@Component
public class ControllerAfter  {

   @Pointcut("execution(public * com.glcxw.*.controller..*.*(..))")
   public void pointCut(){

   }

   @AfterReturning(pointcut = "pointCut()",returning = "returnMsg")
   public void doAfterReturn(JoinPoint joinPoint, Object returnMsg) throws IOException {
      if (returnMsg instanceof String) {
         HttpServletResponse response = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getResponse();
         assert response != null;
         response (response, (String) returnMsg);
      }
   }

   /**
    * wuqiangfu special annotation
    *
    * @param response  响应对象
    * @return v
    * @Description:  响应字符串
    */
   private void response (HttpServletResponse response, String data) throws IOException {
      response.setStatus(CodeType.SUCCESS.getStatus());
      response.setHeader("Access-Control-Allow-Origin", "*");
      ResultEntity<String> result = new ResultEntity<>(CodeType.SUCCESS.getCode(),CodeType.SUCCESS.getMessage(),data, true);
      response.setContentType("text/json;charset=utf-8");
      response.setCharacterEncoding("utf-8");
      response.getWriter().write(JSONObject.toJSONString(result));
      response.getWriter().close();
   }
}
