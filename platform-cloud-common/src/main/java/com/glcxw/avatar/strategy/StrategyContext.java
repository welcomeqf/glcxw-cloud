package com.glcxw.avatar.strategy;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.yadea.avatar.strategy
 * @FileName:       StrategyContext.java
 * @ClassName:      StrategyContext
 * @Description:    策略上下文对象
 * @Author:         wuqiangfu
 * @CreateDate:     2021/6/23 15:24
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/6/23 15:24
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
public class StrategyContext {

   private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

   /**
    * wuqiangfu special annotation
    *
    * @param  versionInfo  版本
    * @return v
    * @Description:  设置版本信息
    */
   public static void setVersionStrategy (String versionInfo) {
      contextHolder.set(versionInfo);
   }

   /**
    * wuqiangfu special annotation
    *
    * @return v
    * @Description:  得到版本信息
    */
   public static String getVersionStrategy () {
      return contextHolder.get();
   }

   /**
    * wuqiangfu special annotation
    *
    * @param
    * @return v
    * @Description:  移除ThreadLocal
    */
   public static void remove () {
      contextHolder.remove();
   }
}
