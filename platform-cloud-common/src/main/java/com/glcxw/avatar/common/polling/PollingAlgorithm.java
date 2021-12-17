package com.glcxw.avatar.common.polling;

import com.glcxw.avatar.common.enums.PollingServiceEnums;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.yadea.avatar.common.polling
 * @FileName:       PollingAlgorithm.java
 * @ClassName:      PollingAlgorithm
 * @Description:    简单轮询算法实现
 * @Author:         wuqiangfu
 * @CreateDate:     2021/5/19 13:45
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/5/19 13:45
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
public class PollingAlgorithm {

   /**
    *  初始化容器
    *  初始key: 1. 业务一
    *          2. 业务二
    *          ....
    */
   private Map<Integer, AtomicInteger> map = new ConcurrentHashMap<>();

   /**
    *   标记符号
    */
   private final String SIGN = "_";

   /**
    * wuqiangfu special annotation
    *
    * @param  key  KEY表示类型 --与枚举中key对应
    * @param name  名称
    * @return v
    * @Description:  轮询得到一个处理后的值(需与业务结合)
    */
   public String getDealValue (Integer key, String name) {
      Integer currentValue = getCurrentValue(key);
      if (currentValue > 0) {
         return name + SIGN + currentValue;
      }
      return name;
   }

   /**
    * wuqiangfu special annotation
    *
    * @param  key  KEY表示类型 --与枚举中key对应
    * @return v
    * @Description:  轮询得到一个处理后的值(需与业务结合)
    */
   public Integer getDealValue (Integer key) {
      return getCurrentValue(key);
   }

   /**
    * wuqiangfu special annotation
    *
    * @param  key  KEY表示类型 --与枚举中key对应
    * @return v
    * @Description:  返回当前次轮询的值
    */
   private Integer getCurrentValue(Integer key) {
      AtomicInteger atomicInteger = getValue(key);
      Integer count = PollingServiceEnums.getValue(key);
      if (atomicInteger.get() >= count) {
         setValue(key, new AtomicInteger(0));
         return 0;
      }
      atomicInteger.addAndGet(1);
      setValue(key, atomicInteger);
      return atomicInteger.get();
   }

   /**
    * wuqiangfu special annotation
    *
    * @return v
    * @Description:  加入容器
    */
   private void setValue (Integer key, AtomicInteger value) {
      map.put(key, value);
   }

   /**
    * wuqiangfu special annotation
    *
    * @return v
    * @Description:  得到当前值
    */
   private AtomicInteger getValue (Integer key) {
      AtomicInteger value = map.get(key);
      if (value == null) {
         return new AtomicInteger(-1);
      }
      return map.get(key);
   }


}
