package com.glcxw.avatar.exception.anntation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.glcxw.avatar.exception.anntation
 * @FileName:       IgnoreResponseAdvice.java
 * @ClassName:      IgnoreResponseAdvice
 * @Description:    忽略全局返回响应包装
 * @Author:         wuqiangfu
 * @CreateDate:     2021/8/20 10:23
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/8/20 10:23
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface IgnoreResponseAdvice {
}
