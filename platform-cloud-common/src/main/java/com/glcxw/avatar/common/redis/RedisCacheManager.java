package com.glcxw.avatar.common.redis;

import com.glcxw.avatar.common.enums.CodeType;
import com.glcxw.avatar.common.utils.NumberUtils;
import com.glcxw.avatar.exception.ApplicationException;
import net.logstash.logback.encoder.org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.types.Expiration;

import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.njll.iep.redis
 * @FileName:       RedisService.java
 * @ClassName:      RedisService
 * @Description:    redis服务类
 * @Author:         wuqiangfu
 * @CreateDate:     2020/12/4 20:49
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2020/12/4 20:49
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
public class RedisCacheManager {

   private final RedisTemplate<String,String> redisTemplate;

   public RedisCacheManager(RedisTemplate<String,String> redisTemplate) {
      this.redisTemplate = redisTemplate;
   }

   private ThreadLocal<Map<String,String>> local = new ThreadLocal<>();

   private final Logger logger = LoggerFactory.getLogger(this.getClass());

   /**
    * wuqiangfu special annotation
    *
    * @param key:值
    * @return v
    * @Description:  获取分布式锁  默认超时时间10S
    */
   public Boolean getLock (String key) {
      return getLock(key, 10);
   }

   /**
    * wuqiangfu special annotation
    *
    * @param time 时间 单位秒
    * @param key key
    * @return v
    * @Description:  获取分布式锁
    */
   public Boolean getLock (String key, long time) {
      if (time > 0) {
         Map<String, String> map = local.get();
         String val = NumberUtils.generator();
         if (map == null) {
            map = new HashMap<>();
         } else {
            String str = map.get(key);
            if (StringUtils.isNotBlank(str)) {
               //已上锁
               return false;
            }
         }
         map.put(key, val);
         local.set(map);
         RedisConnection conn = Objects.requireNonNull(redisTemplate.getConnectionFactory()).getConnection();
         return conn.set(key.getBytes(StandardCharsets.UTF_8),val.getBytes(StandardCharsets.UTF_8), Expiration.seconds(time), RedisStringCommands.SetOption.ifAbsent());
      }
      throw new ApplicationException(CodeType.SERVICE_ERROR, "锁时间不能小于0");
   }

   /**
    * wuqiangfu special annotation
    *
    * @param
    * @return v
    * @Description:  删除redis中值  一个或多个
    */
   public void delete (String...key) {
      if (key != null && key.length == 1) {
         redisTemplate.delete(key[0]);
      } else {
         assert key != null;
         redisTemplate.delete(Arrays.asList(key));
      }
   }

   /**
    * wuqiangfu special annotation
    *
    * @param key 值
    * @return v
    * @Description:  删除分布式锁
    */
   public Boolean deleteLock (String key) {
      Map<String, String> map = local.get();
      if (map == null) {
         logger.error("deleteLock:: 获取Map失败");
         return false;
      }
      String str = map.get(key);
      if (StringUtils.isBlank(str)) {
         logger.error("deleteLock:: 获取val失败");
         return false;
      }
      String val = this.get(key);
      if (str.equals(val)) {
         delete(key);
         map.remove(key);
         local.remove();
         return true;
      }
      return false;
   }

   /**
    * wuqiangfu special annotation
    *
    * @param
    * @return v
    * @Description:  获取值
    */
   public String get (String key) {
      return redisTemplate.opsForValue().get(key);
   }

   /**
    *@Description: 设置值
    *@Param: key,value
    *@return:
    *@Author: wangjing
    *@date: 2021/5/5 16:51
    */
   public void set (String key,String value) {redisTemplate.opsForValue().set(key,value);}

   /**
    * wuqiangfu special annotation
    *
    * @param key 键
    * @return v  先进先出
    * @Description:  从右边将集合加入到redis中
    */
   public void setRightList (String key, List<String> list) {
      redisTemplate.opsForList().rightPushAll(key,list);
   }

   /**
    * wuqiangfu special annotation
    *
    * @param key  键
    * @return v
    * @Description:  取出队列中所有的值
    */
   public List<String> getList (String key) {
      return redisTemplate.opsForList().range(key,0,-1);
   }
}
