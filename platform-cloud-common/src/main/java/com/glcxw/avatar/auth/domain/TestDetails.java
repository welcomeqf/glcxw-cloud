package com.glcxw.avatar.auth.domain;

import java.util.List;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.glcxw.avatar.auth.domain
 * @FileName:       TestDetails.java
 * @ClassName:      TestDetails
 * @Description:    测试类
 * @Author:         wuqiangfu
 * @CreateDate:     2021/8/23 10:13
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/8/23 10:13
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
public class TestDetails extends BaseDetails{

   public TestDetails(String number, String phone, String name, String username, String headUrl, List<String> roles) {
      super.setNumber(number);
      super.setPhone(phone);
      super.setName(name);
      super.setUsername(username);
      super.setHeadUrl(headUrl);
      super.setRoles(roles);
   }

   public TestDetails () {
      super.setNumber("9999");
      super.setPhone("19999999999");
      super.setName("dev小开发");
      super.setUsername("dev小开发");
      super.setHeadUrl("test");
      super.setRoles(null);
   }
}
