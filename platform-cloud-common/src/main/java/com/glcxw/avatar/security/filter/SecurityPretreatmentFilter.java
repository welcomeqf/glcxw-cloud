package com.glcxw.avatar.security.filter;

import com.glcxw.avatar.security.context.service.SecurityContextHolder;
import com.glcxw.avatar.strategy.StrategyContext;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.glcxw.avatar.security.filter
 * @FileName:       SecurityPretreatmentFilter.java
 * @ClassName:      SecurityPretreatmentFilter
 * @Description:    security准备工作过滤
 * @Author:         wuqiangfu
 * @CreateDate:     2021/8/20 17:09
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/8/20 17:09
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
public class SecurityPretreatmentFilter extends OncePerRequestFilter {

    @Override
    protected boolean decideDispatch(HttpServletRequest request) {
        return request != null;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws Exception {
        SecurityContextHolder.clearContext();
        StrategyContext.remove();
        if (this.logger.isInfoEnabled()) {
            this.logger.debug("For any request, the pretreatment is refresh SecurityContextHolder: " + SecurityContextHolder.getContext());
        }
        chain.doFilter(request, response);
    }
}
