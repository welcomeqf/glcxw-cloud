package com.glcxw.avatar.common.utils;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.glcxw.avatar.common.utils
 * @FileName:       StringUtils.java
 * @ClassName:      StringUtils
 * @Description:    字符串工具类
 * @Author:         wuqiangfu
 * @CreateDate:     2021/8/24 16:54
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/8/24 16:54
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
public class StringUtils {

   /**
    * wuqiangfu special annotation
    *
    * @param  cs  字符串
    * @return v
    * @Description:  判断字符串是否为空(空格也算为空)
    */
   public static boolean isBlank(CharSequence cs) {
      int strLen;
      if (cs == null || (strLen = cs.length()) == 0) {
         return true;
      }
      for (int i = 0; i < strLen; i++) {
         if (!Character.isWhitespace(cs.charAt(i))) {
            return false;
         }
      }
      return true;
   }

   /**
    * wuqiangfu special annotation
    *
    * @param cs  字符串
    * @return v
    * @Description:  判断字符串是否不为空(空格也算为空)
    */
   public static boolean isNotBlank(CharSequence cs) {
      return !isBlank(cs);
   }

   /**
    * wuqiangfu special annotation
    *
    * @param cs  字符串
    * @return v
    * @Description:  判断字符串是否为空 (空格不算为空)
    */
   public static boolean isEmpty(CharSequence cs) {
      return cs == null || cs.length() == 0;
   }

   /**
    * wuqiangfu special annotation
    *
    * @param cs 字符串
    * @return v
    * @Description:  判断字符串是否不为空 (空格不算为空)
    */
   public static boolean isNotEmpty(CharSequence cs) {
      return !isEmpty(cs);
   }
}
