package com.glcxw.avatar.auth;

import com.glcxw.avatar.auth.domain.TestDetails;
import com.glcxw.avatar.security.context.Authentication;
import com.glcxw.avatar.security.context.GrantedAuthority;
import com.glcxw.avatar.security.context.service.SimpleGrantedAuthority;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.glcxw.avatar.auth
 * @FileName:       TestAuth.java
 * @ClassName:      TestAuth
 * @Description:    测试token类
 * @Author:         wuqiangfu
 * @CreateDate:     2021/8/23 10:10
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/8/23 10:10
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
public class TestAuth implements Authentication {

   private TestDetails testDetails;

   private List<SimpleGrantedAuthority> authorities;

   public TestAuth(TestDetails details) {
      this.testDetails = details;
      if (details.getRoles() != null && !details.getRoles().isEmpty()) {
         authorities = new ArrayList<>(details.getRoles().size());
         this.testDetails.getRoles().forEach(item -> authorities.add(new SimpleGrantedAuthority(item)));
      }
   }

   @Override
   public Object getDetails() {
      return this.testDetails;
   }

   @Override
   public Object getPrincipal() {
      return this.testDetails.getNumber();
   }

   @Override
   public boolean isAuthenticated() {
      return false;
   }

   @Override
   public void setAuthenticated(boolean authenticated) {

   }

   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
      return (authorities != null && !authorities.isEmpty()) ? authorities : null;
   }
}
