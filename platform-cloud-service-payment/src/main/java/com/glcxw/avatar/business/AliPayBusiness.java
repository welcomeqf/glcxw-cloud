package com.glcxw.avatar.business;

import com.glcxw.avatar.domain.param.AliSignParam;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.glcxw.avatar.business
 * @FileName:       AliPayBusiness.java
 * @ClassName:      AliPayBusiness
 * @Description:    阿里支付宝业务层
 * @Author:         wuqiangfu
 * @CreateDate:     2021/9/27 13:47
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/9/27 13:47
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
public interface AliPayBusiness {

   /**
    * wuqiangfu special annotation
    *
    * @param  param  签约参数
    * @return v
    * @Description:  支付宝预签约
    */
   String aliSign (AliSignParam param);

   /**
    * wuqiangfu special annotation
    *
    * @return v
    * @Description:  支付宝解约
    */
   void unSign ();
}
