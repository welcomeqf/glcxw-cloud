package com.glcxw.avatar.security.filter;

import com.glcxw.avatar.auth.TestAuth;
import com.glcxw.avatar.auth.domain.TestDetails;
import com.glcxw.avatar.common.constant.AcceptTypeConstant;
import com.glcxw.avatar.security.context.Authentication;
import com.glcxw.avatar.security.context.service.SecurityContextHolder;
import com.glcxw.avatar.security.token.AccessTokenServices;
import net.logstash.logback.encoder.org.apache.commons.lang.StringUtils;
import org.springframework.context.MessageSource;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.glcxw.avatar.security.filter
 * @FileName:       BearerAuthenticationFilter.java
 * @ClassName:      BearerAuthenticationFilter
 * @Description:    token过滤处理
 * @Author:         wuqiangfu
 * @CreateDate:     2021/8/20 17:14
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/8/20 17:14
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
public class BearerAuthenticationFilter extends OncePerRequestFilter {

    private String accessTokenName = "access_token";

    private String refreshTokenName = "refresh_token";

    private String authorizationName = "Authorization";

    private String internationalizationName = "Internationalization";

    private AccessTokenServices accessTokenServices;

    public BearerAuthenticationFilter(AccessTokenServices accessTokenServices) {
        this.accessTokenServices = accessTokenServices;
    }

    @Override
    protected boolean decideDispatch(HttpServletRequest request) {
        return request != null && accessTokenServices != null;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws Exception {
        String authorizationToken = getAuthorizationByRequest(request);
        String internationalizationInfo = request.getHeader(internationalizationName);
        if (authorizationToken != null) {
            SecurityContextHolder.getContext().setAuthentication(accessTokenServices.loadAuthentication(authorizationToken));
            if (this.logger.isInfoEnabled()) {
                this.logger.debug("Populated SecurityContextHolder with token: '" + SecurityContextHolder.getContext().getAuthentication() + "'");
            }
        } else if (this.logger.isInfoEnabled()) {
            this.logger.debug("SecurityContextHolder not populated with token, because access_token or authorization cannot exist in the request");
        }
        if (internationalizationInfo != null && internationalizationInfo.equals(AcceptTypeConstant.DEVELOPMENT_RPC)) {
            internationalizationOption();
        }
        chain.doFilter(request, response);
    }

    private String getAuthorizationByRequest(HttpServletRequest request) {
        String authorizationToken = request.getHeader(authorizationName);
        if (StringUtils.isBlank(authorizationToken) && StringUtils.isBlank(request.getParameter(accessTokenName))) {
            return request.getParameter(refreshTokenName);
        }
        return StringUtils.isBlank(authorizationToken) ? request.getParameter(accessTokenName) : authorizationToken.substring(7);
    }

    private void internationalizationOption () {
        SecurityContextHolder.getContext().setAuthentication (getAuthentication ());
    }

    private Authentication getAuthentication () {
        return new TestAuth(new TestDetails());
    }

}
