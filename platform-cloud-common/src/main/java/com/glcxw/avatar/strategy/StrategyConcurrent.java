package com.glcxw.avatar.strategy;

import java.util.concurrent.ConcurrentHashMap;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.yadea.avatar.strategy
 * @FileName:       StrategyConcurrent.java
 * @ClassName:      StrategyConcurrent
 * @Description:    策略存储
 * @Author:         wuqiangfu
 * @CreateDate:     2021/6/24 9:19
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/6/24 9:19
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
public class StrategyConcurrent<T> {

   private ConcurrentHashMap<String, T> strategy;

   public StrategyConcurrent () {
      strategy = new ConcurrentHashMap<>();
   }
   
   /**
    * wuqiangfu special annotation
    *
    * @param  key key
    * @param t  策略对象
    * @return v
    * @Description:  存入所有策略
    */
   public void put (String key, T t) {
      strategy.put(key, t);
   }

   /**
    * wuqiangfu special annotation
    *
    * @param key  key
    * @return v
    * @Description:  取值
    */
   public T get (String key) {
      return strategy.get(key);
   }
}
