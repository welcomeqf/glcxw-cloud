package com.glcxw.avatar.pay.fallback;

import com.glcxw.avatar.common.domain.ResultEntity;
import com.glcxw.avatar.pay.PayFeign;
import com.glcxw.avatar.pay.dto.PayDto;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

/**
 * wuqiangfu special annotation
 *
 * @Package: com.glcxw.avatar.pay.fallback
 * @FileName: PayFeignFallback.java
 * @ClassName: PayFeignFallback
 * @Description: 支付熔断
 * @Author: wuqiangfu
 * @CreateDate: 2021/8/23 16:01
 * @UpdateUser: wuqiangfu
 * @UpdateDate: 2021/8/23 16:01
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
@Component
public class PayFeignFallback implements PayFeign {


   @Override
   public ResultEntity<PayDto> getDataTest(int id) {
      return ResultEntity.feignFail();
   }
}
