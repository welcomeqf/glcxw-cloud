package com.glcxw.configure.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.glcxw.configure.security
 * @FileName:       SecurityPathsProperty.java
 * @ClassName:      SecurityPathsProperty
 * @Description:    无需认证路径过滤
 * @Author:         wuqiangfu
 * @CreateDate:     2021/9/23 10:14
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/9/23 10:14
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
@ConfigurationProperties(
        prefix = "security.exclude"
)
@Component
public class SecurityPathsProperty {

    @Getter
    @Setter
    private String[] filterPaths;

    public List<String> buildSecurityRequestMatcher() {
        return Arrays.asList(filterPaths);
    }


}
