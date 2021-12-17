package com.glcxw.avatar.jpush.client;

import com.alibaba.fastjson.JSONObject;
import com.glcxw.avatar.httpclient.HttpClient;
import com.glcxw.avatar.httpclient.HttpResult;
import com.glcxw.avatar.jpush.entity.*;
import com.glcxw.avatar.jpush.model.MessageProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.yadea.avatar.message.client
 * @FileName:       PushClient.java
 * @ClassName:      PushClient
 * @Description:    极光推送客户端
 * @Author:         wuqiangfu
 * @CreateDate:     2021/4/20 9:40
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/4/20 9:40
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
public class PushClient {

   private final HttpClient httpService;

   private final MessageProperties messageProperties;

   public PushClient(HttpClient httpService, MessageProperties messageProperties) {
      this.httpService = httpService;
      this.messageProperties = messageProperties;
   }

   private final static Logger logger = LoggerFactory.getLogger(PushClient.class);

   /**
    * wuqiangfu special annotation
    *
    * @param  alert  弹出框消息
    * @param msgContent 消息内容
    * @param tags  标签(注： 标签上限20个, 即该集合的长度不能大于20)
    * @return v
    * @Description:  立即发送消息 (发送给指定标签)
    */
   public void pushMessage (String alert, String msgContent, List<String> tags,String msgType) {
      if (checkParam (alert, msgContent, tags)) {
         logger.error("极光推送消息参数错误,  不能为空");
      }
      HttpResult post;
      try {
         logger.error("极光推送消息参数: 路径:[{}]", messageProperties.getPushUrl());
         post = httpService.post(messageProperties.getPushUrl(), JSONObject.toJSONString(new SchedulePushParam(alert,msgContent,
               messageProperties.getEnvironment(), tags,0,msgType)),getToken(getParamToken()));
         logger.info("发送消息返回:[{}]", post);
      }catch (Exception e) {
         e.printStackTrace();
      }
   }

   /**
    * wuqiangfu special annotation
    *
    * @param  alert  弹出框消息
    * @param msgContent 消息内容
    * @return v
    * @Description:  立即发送消息 (发送给所有人)
    */
   public void pushMessage (String alert, String msgContent, String msgType) {
      if (checkParam (alert, msgContent)) {
         logger.error("极光推送消息参数错误,  不能为空");
      }
      HttpResult post;
      try {
         post = httpService.post(messageProperties.getPushUrl(), JSONObject.toJSONString(new PushAllParam(
               alert,msgContent,messageProperties.getEnvironment(), msgType)), getToken(getParamToken()));
         logger.info("发送消息返回:[{}]", post);
      }catch (Exception e) {
         e.printStackTrace();
      }
   }

   /**
    * wuqiangfu special annotation
    *
    * @param registrationId 设备id
    * @param userNumber  用户编号
    * @param tagList 标签集合
    * @return v
    * @Description:  设置用户标签,别名
    */
   public void setUser (String registrationId, String userNumber, List<String> tagList) {
      HttpResult post;
      try {
         logger.error("极光推送消息参数: 路径:[{}]", messageProperties.getDevicesUrl() + "/" + registrationId);
         post = httpService.post(messageProperties.getDevicesUrl() + "/" + registrationId, JSONObject.toJSONString(new PushParam(
               userNumber, tagList)),getToken(getParamToken()));
         logger.info("设置用户标签或别名返回:[{}]", post);
      }catch (Exception e) {
         e.printStackTrace();
      }
   }

   /**
    * wuqiangfu special annotation
    *
    * @param registrationId  设备id
    * @param tagList 设置用户的所有标签
    * @return v
    * @Description:   移除该用户的所有标签和别名
    */
   public void removeUser (String registrationId, List<String> tagList) {
      HttpResult post;
      try {
         post = httpService.post(messageProperties.getDevicesUrl() + "/" + registrationId, JSONObject.toJSONString(new PushParam(
               tagList)),getToken(getParamToken()));
         logger.info("[移除该用户的所有标签和别名]: 设置用户标签或别名返回:[{}]", post);
      }catch (Exception e) {
         e.printStackTrace();
      }
   }

   /**
    * wuqiangfu special annotation
    *
    * @param  number  唯一编号
    * @param time 发送时间
    * @param alert 发送标签
    * @param msgContent 发送内容
    * @param type 0- 标签  1-别名
    * @return v
    * @Description:  创建定时任务发送消息 (发送给指定标签)
    */
   public HttpResult setScheduleUser (String number, String time, String alert, String msgContent,List<String> values, int type, String msgType) {
      if (checkParam (alert, msgContent, values)) {
         logger.error("极光推送消息参数错误,  不能为空");
      }
      HttpResult post;
      try {
         post = httpService.post(messageProperties.getScheduleUrl(), JSONObject.toJSONString(new ScheduleModel(number,
               messageProperties.getEnvironment(),time,alert, msgContent,values, type,msgType)),getToken(getParamToken()));
         logger.info("创建定时任务发送消息返回:[{}], 发送时间为: [{}], 发送对象为指定人群:[{}]", post, time,values);
         return post;
      }catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }

   /**
    * wuqiangfu special annotation
    *
    * @param  number  唯一编号
    * @param time 发送时间
    * @param alert 发送标签
    * @param msgContent 发送内容
    * @return v
    * @Description:  创建定时任务发送消息 (发送给所有人)
    */
   public HttpResult setScheduleUser (String number, String time, String alert, String msgContent,String msgType) {
      if (checkParam (alert, msgContent)) {
         logger.error("极光推送消息参数错误,  不能为空");
      }
      HttpResult post;
      try {
         post = httpService.post(messageProperties.getScheduleUrl(), JSONObject.toJSONString(new ScheduleAllPushParam(number,
               messageProperties.getEnvironment(),time, alert,msgContent,msgType)),getToken(getParamToken()));
         logger.info("创建定时任务发送消息返回:[{}], 发送时间为: [{}], 发送对象为所有人", post, time);
         return post;
      }catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }

   /**
    * wuqiangfu special annotation
    *
    * @param scheduleId  定时任务id
    * @param time 发送时间
    * @return v
    * @Description:  修改定时任务发送消息（只修改发送时间）
    */
   public void updScheduleUser (String scheduleId, String time) {
      HttpResult post;
      try {
         post = httpService.put(messageProperties.getScheduleUrl() + "/" + scheduleId, JSONObject.toJSONString(new ScheduleModel(time)),
               getToken(getParamToken()));
         logger.info("修改定时任务发送消息返回:[{}], 修改发送时间为: [{}]", post, time);
      }catch (Exception e) {
         e.printStackTrace();
      }
   }

   /**
    * wuqiangfu special annotation
    *
    * @param scheduleId  定时任务id
    * @return v
    * @Description:  删除定时任务
    */
   public void deleteScheduleUser (String scheduleId) {
      HttpResult post;
      try {
         post = httpService.delete(messageProperties.getScheduleUrl() + "/" + scheduleId,getToken(getParamToken()));
         logger.info("删除定时任务发送消息返回:[{}]", post);
      }catch (Exception e) {
         e.printStackTrace();
      }
   }

   /**
    * wuqiangfu special annotation
    *
    * @param
    * @return v
    * @Description:  检测参数
    */
   private boolean checkParam (String alert, String msgContent, List<String> tags) {
      if (tags != null && !tags.isEmpty()) {
         return checkList (tags);
      }
      if (StringUtils.isEmpty(alert) || StringUtils.isEmpty(msgContent) || tags == null) {
         return true;
      }
      return false;
   }

   /**
    * wuqiangfu special annotation
    *
    * @param
    * @return v
    * @Description:  检测参数
    */
   private boolean checkParam (String alert, String msgContent) {
      if (StringUtils.isEmpty(alert) || StringUtils.isEmpty(msgContent)) {
         return true;
      }
      return false;
   }

   /**
    * wuqiangfu special annotation
    *
    * @param  tags  标签集合
    * @return v
    * @Description:  检测标签参数
    */
   private boolean checkList (List<String> tags) {
//      if (tags.size() > 10) {
//         return true;
//      }
      return false;
   }

   /**
    * wuqiangfu special annotation
    *
    * @return v
    * @Description:  获取token
    */
   private String getToken (String paramHeard) {
      return "Basic " + Base64Utils.encodeToString(paramHeard.getBytes());
   }

   /**
    * wuqiangfu special annotation
    *
    * @return v
    * @Description:  获取极光认证Basic token
    */
   private String getParamToken () {
      return messageProperties.getAppKey() + ":" + messageProperties.getAppSecret();
   }

}
