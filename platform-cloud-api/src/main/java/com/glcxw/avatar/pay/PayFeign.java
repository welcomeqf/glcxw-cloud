package com.glcxw.avatar.pay;

import com.glcxw.avatar.common.constant.ServiceDefinition;
import com.glcxw.avatar.common.domain.ResultEntity;
import com.glcxw.avatar.pay.dto.PayDto;
import com.glcxw.avatar.pay.fallback.PayFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * wuqiangfu special annotation
 *
 * @Package: com.glcxw.avatar.pay
 * @FileName: PayFeign.java
 * @ClassName: PayFeign
 * @Description: 支付API
 * @Author: wuqiangfu
 * @CreateDate: 2021/8/23 15:56
 * @UpdateUser: wuqiangfu
 * @UpdateDate: 2021/8/23 15:56
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
@FeignClient(value = ServiceDefinition.PLAT_FROM_PAY, fallback = PayFeignFallback.class)
public interface PayFeign {

   /**
    * wuqiangfu special annotation
    *
    * @return v
    * @Description: 测试feign
    */
   @GetMapping("/api/getDataTest/{id}")
   ResultEntity<PayDto> getDataTest(@PathVariable("id") int id);
}
