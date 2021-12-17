package com.glcxw.avatar.common.constant;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.glcxw.avatar.common.constant
 * @FileName:       AcceptTypeConstant.java
 * @ClassName:      AcceptTypeConstant
 * @Description:    访问类型
 * @Author:         wuqiangfu
 * @CreateDate:     2021/8/20 17:19
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/8/20 17:19
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
public interface AcceptTypeConstant {

   /**
    *  匿名访问
    */
   String ANONYMOUS_RPC = "ANONYMOUS_RPC";

   /**
    *  测试访问
    *  专为开发备用 会生成一个特定的账号test
    */
   String DEVELOPMENT_RPC = "UUID_CHINA_INTERNATIONALIZATION_TEST";
}
