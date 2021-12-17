package com.glcxw.avatar.strategy;

import com.glcxw.avatar.common.constant.VersionConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.yadea.avatar.strategy
 * @FileName:       BaseStrategyService.java
 * @ClassName:      BaseStrategyService
 * @Description:    通用版本策略管理
 * @Author:         wuqiangfu
 * @CreateDate:     2021/6/28 15:10
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/6/28 15:10
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
public abstract class BaseStrategyService<T> {

   private final StrategyConcurrent<T> strategyConcurrent;

   private final static Logger logger = LoggerFactory.getLogger(BaseStrategyService.class);

   public BaseStrategyService(StrategyConcurrent<T> strategyConcurrent, List<T> list) {
      this.strategyConcurrent = strategyConcurrent;
      list.forEach(e -> {
         logger.info("当前策略类:{}", e.getClass().getName());
         strategyConcurrent.put(getVersion(e), e);
      });
      logger.info("注入策略完毕");
   }

   /**
    * wuqiangfu special annotation
    *
    * @return v
    * @Description:  得到具体业务操作对象
    */
   public T getService () {
      String versionStrategy = StrategyContext.getVersionStrategy();
      String value = StringUtils.isEmpty(versionStrategy) ? getServiceName () + VersionConstant.V1 : getServiceName () + versionStrategy;
      return strategyConcurrent.get(value);
   }

   /**
    * wuqiangfu special annotation
    *
    * @param e 策略类对象
    * @return v
    * @Description: 得到版本
    */
   public abstract String getVersion (T e);

   /**
    * wuqiangfu special annotation
    *
    * @return v
    * @Description:  得到业务请求名字
    */
   public abstract String getServiceName ();
}
