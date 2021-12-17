package com.glcxw.avatar.security.filter;

import com.alibaba.fastjson.JSONObject;
import com.glcxw.avatar.common.constant.AcceptTypeConstant;
import com.glcxw.avatar.common.domain.ResultEntity;
import com.glcxw.avatar.common.enums.CodeType;
import com.glcxw.avatar.exception.ApplicationException;
import com.glcxw.avatar.security.context.Authentication;
import com.glcxw.avatar.security.context.service.SecurityContextHolder;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.glcxw.avatar.security.filter
 * @FileName:       AccessAuthFilter.java
 * @ClassName:      AccessAuthFilter
 * @Description:    统一身份认证过滤
 * @Author:         wuqiangfu
 * @CreateDate:     2021/8/20 18:36
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/8/20 18:36
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
public class AccessAuthFilter extends OncePerRequestFilter{

   private final List<String> securityList;

   public AccessAuthFilter (List<String> securityList) {
      this.securityList = securityList;
   }

   @Override
   protected boolean decideDispatch(HttpServletRequest request) {
      return request != null;
   }

   @Override
   protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws Exception {
      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      if (checkAuthentication (request, response, authentication)) {
         if (this.logger.isInfoEnabled()) {
            this.logger.debug("Request servletPath: '" + request.getServletPath() + "', access interceptor passed");
         }
         chain.doFilter(request, response);
      } else {
         if (this.logger.isInfoEnabled()) {
            this.logger.debug("Request servletPath: '" + request.getServletPath() + "', access interceptor forbidden");
         }
         responseError(response);
      }
   }

   private boolean accessAuthorityDecide(Authentication authentication, HttpServletRequest request, HttpServletResponse response) {
      // 业务身份认证拓展
      return true;
   }

   /**
    * wuqiangfu special annotation
    *
    * @param response  响应对象
    * @return v
    * @Description:  响应身份认证失败
    */
   private void responseError (HttpServletResponse response) throws IOException {
      logger.error("Authorization fail error info");
      response.setHeader("Access-Control-Allow-Origin", "*");
      response.setStatus(CodeType.AUTHENTICATION_ERROR.getStatus());
      ResultEntity<String> result = new ResultEntity<>(CodeType.AUTHENTICATION_ERROR.getCode(),CodeType.AUTHENTICATION_ERROR.getMessage(),"",false);
      response.setContentType("text/json;charset=utf-8");
      response.setCharacterEncoding("utf-8");
      response.getWriter().write(JSONObject.toJSONString(result));
   }

   /**
    * wuqiangfu special annotation
    *
    * @return v
    * @Description:  检测头部信息过滤认证
    */
   private Boolean checkAuthentication (HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws Exception {
      String acceptType = request.getHeader("Accept-Type");
      if (acceptType != null) {
         return AcceptTypeConstant.ANONYMOUS_RPC.equals(acceptType);
      } else if (authentication != null) {
         return accessAuthorityDecide(authentication, request, response);
      } else {
         return securityList.stream().anyMatch(item -> item.matches(request.getRequestURI()));
      }
   }

}
