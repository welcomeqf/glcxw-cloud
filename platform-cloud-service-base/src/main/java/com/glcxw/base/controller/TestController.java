package com.glcxw.base.controller;

import com.glcxw.avatar.auth.TestAuth;
import com.glcxw.avatar.auth.domain.TestDetails;
import com.glcxw.avatar.common.utils.TestDataUtils;
import com.glcxw.avatar.security.token.AccessTokenServices;
import com.glcxw.base.business.TestBusiness;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.glcxw.base.controller
 * @FileName:       TestController.java
 * @ClassName:      TestController
 * @Description:    测试控制层
 * @Author:         wuqiangfu
 * @CreateDate:     2021/8/20 9:38
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/8/20 9:38
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
@RestController
@RequestMapping("/test")
public class TestController {

   @Autowired
   private TestBusiness testBusiness;

//   @Autowired
//   private PayFeign payFeign;

   @Autowired
   private AccessTokenServices accessTokenServices;

   private static final Logger logger = LoggerFactory.getLogger(TestController.class);

   @GetMapping("/get")
   public String test () {
      //testBusiness.insert();
      TestDetails testDetails = new TestDetails("33", "11", "11", "11", "11", null);
      String accessToken = accessTokenServices.createAccessToken(new TestAuth(testDetails));
      return accessToken;
   }

   @GetMapping("/get1")
   public void test1 () {
      System.out.println("--->" + TestDataUtils.getNumber() + TestDataUtils.getName());
      //ResultEntity<PayDto> result = payFeign.getDataTest(1);
//      System.out.println(result);
//      if (!result.getSuccess()) {
//         throw new ApplicationException(result.getCode(),result.getMessage());
//      }

   }


}
