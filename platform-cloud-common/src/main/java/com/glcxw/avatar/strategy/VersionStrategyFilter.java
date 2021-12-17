package com.glcxw.avatar.strategy;

import com.glcxw.avatar.security.filter.OncePerRequestFilter;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.yadea.avatar.strategy
 * @FileName:       VersionStrategyFilter.java
 * @ClassName:      VersionStrategyFilter
 * @Description:    版本策略过滤器
 * @Author:         wuqiangfu
 * @CreateDate:     2021/6/23 15:19
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/6/23 15:19
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
public class VersionStrategyFilter extends OncePerRequestFilter {

   private final String VERSION_STRATEGY = "versionStrategy";

   @Override
   protected boolean decideDispatch(HttpServletRequest request) {
      return true;
   }

   @Override
   protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws Exception {
      String version = getVersionInfo(request);
      if (StringUtils.isNotBlank(version)) {
         StrategyContext.setVersionStrategy(version);
      }
      filterChain.doFilter(request, response);
   }

   /**
    * wuqiangfu special annotation
    *
    * @param request  请求对象
    * @return v
    * @Description:  得到请求头的版本数据
    */
   private String getVersionInfo(HttpServletRequest request) {
      return request.getHeader(VERSION_STRATEGY);
   }


}
