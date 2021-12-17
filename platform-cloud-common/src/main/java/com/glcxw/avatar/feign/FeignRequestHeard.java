package com.glcxw.avatar.feign;

import com.glcxw.avatar.common.constant.AcceptTypeConstant;
import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.glcxw.avatar.feign
 * @FileName:       FeignRequestHeard.java
 * @ClassName:      FeignRequestHeard
 * @Description:    feign请求头处理
 * @Author:         wuqiangfu
 * @CreateDate:     2021/8/24 10:28
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/8/24 10:28
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
public class FeignRequestHeard implements RequestInterceptor {

   @Override
   public void apply(RequestTemplate requestTemplate) {
      requestTemplate.header("Accept-Type", AcceptTypeConstant.ANONYMOUS_RPC);
   }
}
