package com.glcxw.avatar.common.utils;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.njll.iep.util
 * @FileName:       DateUtil.java
 * @ClassName:      DateUtil
 * @Description:    日期类
 * @Author:         wuqiangfu
 * @CreateDate:     2020/12/3 15:54
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2020/12/3 15:54
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
public class DateUtils {

   public static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

   public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

   public static final String SIMPLE_DATE_FORMAT = "yyyyMMddHHmmss";

   private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_FORMAT);

   private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT);

   private static final DateTimeFormatter simpleDateFormatter = DateTimeFormatter.ofPattern(SIMPLE_DATE_FORMAT);

   private static final DateTimeFormatter SIMPLE_DATE_FORMATTER = DateTimeFormatter.ofPattern(SIMPLE_DATE_FORMAT);

   public static String formatDateTime(LocalDate date) {
      return dateTimeFormatter.format(date);
   }

   public static String formatDateTime(LocalDateTime date) {
      return dateTimeFormatter.format(date);
   }

   public static String formatSimpleDateTime(LocalDateTime date) {
      return simpleDateFormatter.format(date);
   }

   public static LocalDateTime parseDateTime(String time){ return LocalDateTime.parse(time, dateTimeFormatter); }

   public static LocalDateTime parseDateTime(Date date){ return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(); }

   public static String formatDate(LocalDate date) {
      return dateFormatter.format(date);
   }

   public static String formatDate(LocalDateTime date) {
      return dateFormatter.format(date);
   }

   public static LocalDate parseDate(String date){ return LocalDate.parse(date,dateFormatter); }

   public static LocalDateTime parseWxDateTime(String date) {
      return LocalDateTime.parse(date, SIMPLE_DATE_FORMATTER);
   }

   /**
    * wuqiangfu special annotation
    *
    * java1.8之后判断
    *
    * @param nowTime 需要比较时间
    * @param startTime 开始时间
    * @param endTime 结束时间
    * @return v true-在   false-不在
    * @Description:   判断该时间是否在时间范围之内
    */
   public static boolean isEffectiveLocalDate (LocalDateTime nowTime, LocalDateTime startTime, LocalDateTime endTime) {
      if(nowTime.isAfter(startTime) && nowTime.isBefore(endTime)){
         return true;
      }
      return false;
   }

   /**
    * wuqiangfu special annotation
    *
    * @param
    * @return v
    * @Description:  获取今年
    */
   public static String getLocalYear () {
      return String.valueOf(LocalDate.now().getYear());
   }

   /**
    * wuqiangfu special annotation
    *
    * @param remindTime  时间戳
    * @return v
    * @Description:  通过时间戳(秒)返回时间
    */
   public static LocalDateTime getTime (Long remindTime) {
      return parseDateTime(new Date(remindTime));
   }

   /**
    * wuqiangfu special annotation
    *
    * @param  time  时间
    * @return v
    * @Description:  检验时间是否在当前时间之后
    */
   public static Boolean isTimeFrom (LocalDateTime time) {
      Duration between = Duration.between(LocalDateTime.now(), time);
      return between.toMillis() <= 0;
   }
}
