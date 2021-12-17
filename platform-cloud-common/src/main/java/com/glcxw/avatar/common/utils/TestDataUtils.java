package com.glcxw.avatar.common.utils;

import com.glcxw.avatar.auth.domain.TestDetails;
import com.glcxw.avatar.security.context.Authentication;
import com.glcxw.avatar.security.context.service.SecurityContextHolder;
import lombok.Data;
import org.springframework.util.Assert;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.glcxw.avatar.common.utils
 * @FileName:       TestDataUtils.java
 * @ClassName:      TestDataUtils
 * @Description:    测试token数据
 * @Author:         wuqiangfu
 * @CreateDate:     2021/8/23 15:36
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/8/23 15:36
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
@Data
public class TestDataUtils {

   /**
    * yeshengguang special annotation
    *
    * @param
    * @return v
    * @Description: 获取用户编号
    */
   public static String getNumber() {
      return getDetails().getNumber();
   }

   /**
    * yeshengguang special annotation
    *
    * @return v
    * @Description: 获取用户姓名
    */
   public static String getName() {
      return getDetails().getName();
   }

   /**
    * yeshengguang special annotation
    *
    * @return v
    * @Description: 获取登录用户名
    */
   public static String getUsername() {
      return getDetails().getUsername();
   }

   /**
    * yeshengguang special annotation
    *
    * @return v
    * @Description: 获取手机号
    */
   public static String getPhone() {
      return getDetails().getPhone();
   }

   /**
    * yeshengguang special annotation
    *
    * @return v
    * @Description: 获取用户详情对象
    */
   public static TestDetails getDetails() {
      return getDetails(SecurityContextHolder.getContext().getAuthentication());
   }

   /**
    * yeshengguang special annotation
    *
    * @param authentication 授权对象
    * @return v
    * @Description: 获取用户详细信息
    */
   public static TestDetails getDetails(Authentication authentication) {
      Assert.notNull(authentication, "SecurityContextHolder with AdminAuthenticationToken is null");
      return (TestDetails) authentication.getDetails();
   }
}
