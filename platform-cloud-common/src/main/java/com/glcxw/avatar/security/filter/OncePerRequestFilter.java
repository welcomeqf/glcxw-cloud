package com.glcxw.avatar.security.filter;

import com.alibaba.fastjson.JSONObject;
import com.glcxw.avatar.common.domain.ResultEntity;
import com.glcxw.avatar.common.enums.CodeType;
import com.glcxw.avatar.exception.ApplicationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.glcxw.avatar.security.filter
 * @FileName:       OncePerRequestFilter.java
 * @ClassName:      OncePerRequestFilter
 * @Description:    请求筛选过滤器
 * @Author:         wuqiangfu
 * @CreateDate:     2021/8/20 15:40
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/8/20 15:40
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
public abstract class OncePerRequestFilter implements Filter {

   protected final Logger logger = LoggerFactory.getLogger(this.getClass());

   @Override
   public void init(FilterConfig filterConfig) throws ServletException {
   }

   @Override
   public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
      if (servletRequest instanceof HttpServletRequest && servletResponse instanceof HttpServletResponse) {
         HttpServletRequest request = (HttpServletRequest) servletRequest;
         HttpServletResponse response = (HttpServletResponse) servletResponse;
         if (decideDispatch(request)) {
            try {
               this.doFilterInternal(request, response, chain);
            } catch (Exception e) {
               responseError(response, e);
            }
         } else {
            chain.doFilter(request, response);
         }
      } else {
         chain.doFilter(servletRequest, servletResponse);
      }
   }

   @Override
   public void destroy() {
   }

   /**
    * wuqiangfu special annotation
    *
    * @param  request  请求对象
    * @return v
    * @Description:   是否执行过滤
    */
   protected abstract boolean decideDispatch(HttpServletRequest request);

   /**
    * wuqiangfu special annotation
    *
    * @param  request  请求对象
    * @param response 响应对象
    * @param filterChain  放行链
    * @exception
    * @return v
    * @Description:  过滤业务
    */
   protected abstract void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws Exception;


   /**
    * wuqiangfu special annotation
    *
    * @param response  响应对象
    * @return v
    * @Description:  错误信息返回
    */
   private void responseError (HttpServletResponse response, Exception e) throws IOException {
      logger.error("auth error : [{}]", e);
      response.setStatus(CodeType.UNKNOWN_ERROR.getStatus());
      response.setHeader("Access-Control-Allow-Origin", "*");
      ResultEntity<String> result = new ResultEntity<>(CodeType.UNKNOWN_ERROR.getCode(),CodeType.UNKNOWN_ERROR.getMessage(),"",false);
      response.setContentType("text/json;charset=utf-8");
      response.setCharacterEncoding("utf-8");
      response.getWriter().write(JSONObject.toJSONString(result));
   }
}
