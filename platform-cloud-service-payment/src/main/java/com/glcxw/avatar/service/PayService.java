package com.glcxw.avatar.service;

import com.glcxw.avatar.pay.dto.PayDto;
import org.springframework.web.bind.annotation.*;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.glcxw.avatar.service
 * @FileName:       PayService.java
 * @ClassName:      PayService
 * @Description:    支付API
 * @Author:         wuqiangfu
 * @CreateDate:     2021/8/23 15:55
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/8/23 15:55
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
@RestController
public class PayService {

   @GetMapping("/api/getDataTest/{id}")
   public PayDto getDataTest (@PathVariable("id") int id) {
      System.out.println(id);
      PayDto payDto = new PayDto("5656");
      System.out.println("data:" + payDto);
      return payDto;
   }
}
