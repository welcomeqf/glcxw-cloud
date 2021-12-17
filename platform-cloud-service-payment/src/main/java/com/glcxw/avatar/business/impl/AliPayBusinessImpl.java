package com.glcxw.avatar.business.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AccessParams;
import com.alipay.api.domain.AlipayUserAgreementPageSignModel;
import com.alipay.api.domain.AlipayUserAgreementUnsignModel;
import com.alipay.api.request.AlipayUserAgreementPageSignRequest;
import com.alipay.api.request.AlipayUserAgreementUnsignRequest;
import com.alipay.api.response.AlipayUserAgreementPageSignResponse;
import com.alipay.api.response.AlipayUserAgreementUnsignResponse;
import com.glcxw.avatar.business.AliPayBusiness;
import com.glcxw.avatar.common.enums.CodeType;
import com.glcxw.avatar.common.utils.NumberUtils;
import com.glcxw.avatar.constant.AliPayMessage;
import com.glcxw.avatar.domain.param.AliSignParam;
import com.glcxw.avatar.domain.properties.AliPayProperties;
import com.glcxw.avatar.exception.ApplicationException;
import com.glcxw.avatar.observer.PayDataObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.glcxw.avatar.business.impl
 * @FileName:       AliPayBusinessImpl.java
 * @ClassName:      AliPayBusinessImpl
 * @Description:    支付宝业务实现
 * @Author:         wuqiangfu
 * @CreateDate:     2021/9/27 13:48
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/9/27 13:48
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
@Service
public class AliPayBusinessImpl implements AliPayBusiness {

   private final PayDataObserver payDataObserver;

   private final AliPayProperties aliPayProperties;

   private final static Logger logger = LoggerFactory.getLogger(AliPayBusinessImpl.class);

   public AliPayBusinessImpl (PayDataObserver payDataObserver, AliPayProperties aliPayProperties) {
      this.payDataObserver = payDataObserver;
      this.aliPayProperties = aliPayProperties;
   }

   @Override
   public String aliSign(AliSignParam param) {
      AlipayClient alipayClient = getAliPayClient();
      String extAgreementNo = NumberUtils.generator();
      try {
         AlipayUserAgreementPageSignResponse response = alipayClient.sdkExecute(param.aliParamInit (
               extAgreementNo, aliPayProperties.getSignNotifyServerUrl()));
         if (response.isSuccess()) {
            // 业务逻辑--
            return response.getBody();
         } else {
            logger.info("[支付宝预签名调用失败],参数: [{}]", param);
            return "";
         }
      }catch (Exception e) {
         logger.error("[支付宝预签名调用错误],参数: [{}], 错误: ", param, e);
         throw new ApplicationException(CodeType.SERVICE_ERROR);
      }
   }

   @Override
   public void unSign() {
      AlipayClient alipayClient = getAliPayClient();
      try {
         AlipayUserAgreementUnsignResponse response = alipayClient.execute(unSignParamRequest());
         if (!response.isSuccess()) {
            logger.error("解签失败: [{}]", response.getSubMsg());
            throw new ApplicationException(CodeType.SERVICE_ERROR, response.getSubMsg());
         }
      } catch (ApplicationException e) {
         logger.error("[支付宝解签调用错误], 错误: ", e);
         throw e;
      }catch (Exception e) {
         logger.error("[支付宝解签调用错误], 错误: ", e);
         throw new ApplicationException(CodeType.SERVICE_ERROR);
      }
   }

   /**
    * wuqiangfu special annotation
    *
    * @return v
    * @Description: 得到支付宝请求对象
    */
   private AlipayClient getAliPayClient() {
      return new DefaultAlipayClient(aliPayProperties.getUrl(), aliPayProperties.getAppId(), aliPayProperties.getPrivateKey(),
            AliPayMessage.JSON, AliPayMessage.UTF8, aliPayProperties.getPublicKey(), AliPayMessage.RSA2);
   }

   /**
    * wuqiangfu special annotation
    *
    * @param  request  请求对象
    * @return v
    * @Description:  得到支付宝返回的数据
    */
   private Map<String,String> getAliPayParam (HttpServletRequest request) {
      Map<String,String> params = new HashMap<>(32);
      Map<String, String[]> requestParams  = request.getParameterMap();
      if (!Objects.isNull(requestParams)) {
         for (String name : requestParams.keySet()) {
            String[] values = requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
               valueStr = (i == values.length - 1) ? valueStr + values[i]
                     : valueStr + values[i] + ",";
            }
            params.put(name, valueStr);
         }
      }
      return params;
   }

   /**
    * wuqiangfu special annotation
    *
    * @return v
    * @Description:  解签数据参数处理
    */
   private AlipayUserAgreementUnsignRequest unSignParamRequest () {
      AlipayUserAgreementUnsignModel bizModel = new AlipayUserAgreementUnsignModel();
      // 通过查询数据库得到个人的协议号
      bizModel.setAgreementNo("20204910000764331770");
      AlipayUserAgreementUnsignRequest request = new AlipayUserAgreementUnsignRequest();
      request.setBizModel(bizModel);
      request.setNotifyUrl(aliPayProperties.getUnSignNotifyServerUrl());
      return request;
   }
}
