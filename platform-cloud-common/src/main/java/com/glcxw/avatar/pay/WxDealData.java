package com.glcxw.avatar.pay;

import com.github.wxpay.sdk.WXPayUtil;
import com.glcxw.avatar.common.enums.CodeType;
import com.glcxw.avatar.common.utils.DateUtils;
import com.glcxw.avatar.exception.ApplicationException;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.DefaultHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Base64Utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import java.io.*;
import java.math.BigDecimal;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.master.pay.utils
 * @FileName:       WxUtils.java
 * @ClassName:      WxUtils
 * @Description:    微信数据处理
 * @Author:         wuqiangfu
 * @CreateDate:     2021/9/6 15:30
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2021/9/6 15:30
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
public class WxDealData {

   private final Logger logger = LoggerFactory.getLogger(WxDealData.class);

   /**
    * wuqiangfu special annotation
    *
    * @param in 输入流
    * @return v
    * @Description:  流转String
    */
   public String getStreamToStr(InputStream in) {
      if (in != null) {
         try {
            BufferedReader tBufferedReader = new BufferedReader(new InputStreamReader(in));
            StringBuilder tStringBuffer = new StringBuilder();
            String sTempOneLine;
            while ((sTempOneLine = tBufferedReader.readLine()) != null) {
               tStringBuffer.append(sTempOneLine);
            }
            return tStringBuffer.toString();
         } catch (Exception ex) {
            logger.error("类型转换错误,", ex);
            throw new ApplicationException(CodeType.SERVICE_ERROR);
         }
      }
      return null;
   }

   /**
    * wuqiangfu special annotation
    *
    * @param  price 价格
    * @return v
    * @Description: 元转分
    */
   public Integer changeY2F(double price) {
      return new BigDecimal(String.valueOf(price)).multiply(new BigDecimal(String.valueOf(100))).intValue();
   }

   /**
    * wuqiangfu special annotation
    *
    * @param  money  金额(分)
    * @return v
    * @Description:  分转元
    */
   public Double changeF2Y (String money) {
      return (Double.parseDouble(money) / 100);
   }

   /**
    * wuqiangfu special annotation
    *
    * @param  payTimeEnd  微信返回的时间
    * @return v
    * @Description:  转换微信响应的时间
    */
   public LocalDateTime getPayTime (String payTimeEnd) {
      if (StringUtils.isNotBlank(payTimeEnd)) {
         return DateUtils.parseWxDateTime(payTimeEnd);
      }
      return null;
   }

   /**
    * wuqiangfu special annotation
    *
    * @param data 请求参数
    * @param requestUrl 请求路径
    * @return v
    * @Description:  微信请求调用
    */
   public Map<String, String> wxPayRequest (Map<String,String> data, String requestUrl) {
      try {
         String xml = WXPayUtil.mapToXml(data);
         String xmlStr = httpsRequest(requestUrl, xml);
         logger.info("[微信请求调用]请求路径: [{}],返回数据: [{}] ", requestUrl, xmlStr);
         return WXPayUtil.xmlToMap(xmlStr);
      } catch (Exception e) {
         logger.error("请求微信服务器异常,", e);
         throw new ApplicationException(CodeType.SERVICE_ERROR);
      }
   }

   /**
    * wuqiangfu special annotation
    *
    * @param  data 请求参数
    * @param requestUrl 请求路径
    * @param privateKey 微信私钥
    * @return v
    * @Description:  微信请求调用
    */
   public Map<String, String> wxPayRequest (Map<String,String> data, String requestUrl, String privateKey) {
      String xml;
      try {
         xml = WXPayUtil.generateSignedXml(data, privateKey);
      } catch (Exception e) {
         logger.error("微信私钥有误,map2xml异常,", e);
         throw new ApplicationException(CodeType.SERVICE_ERROR);
      }
      String xmlStr = httpsRequest(requestUrl, xml);
      logger.info("[微信请求调用]请求路径: [{}],返回数据: [{}] ", requestUrl, xmlStr);
      try {
         return WXPayUtil.xmlToMap(xmlStr);
      } catch (Exception e) {
         logger.error("微信返回数据转换map异常,", e);
         throw new ApplicationException(CodeType.SERVICE_ERROR);
      }
   }

   /**
    * wuqiangfu special annotation
    *
    * @param  data 请求参数
    * @param requestUrl 请求路径
    * @param privateKey 微信私钥
    * @return v
    * @Description:  微信请求调用(需要证书)
    */
   public String wxPayRequest (Map<String,String> data, String requestUrl, String privateKey,String mchId, String certUrl) {
      String xml;
      try {
         xml = WXPayUtil.generateSignedXml(data, privateKey);
      }catch (Exception e) {
         logger.error("微信私钥有误,map2xml异常,", e);
         throw new ApplicationException(CodeType.SERVICE_ERROR);
      }
      String xmlStr;
      try {
         xmlStr = doPostSsl(requestUrl, xml, mchId, certUrl);
         logger.info("[微信请求调用]请求路径: [{}],返回数据: [{}] ", requestUrl, xmlStr);
         return xmlStr;
      }catch (Exception e) {
         logger.error("请求微信服务器异常,", e);
         throw new ApplicationException(CodeType.SERVICE_ERROR);
      }
   }

   /**
    * wuqiangfu special annotation
    *
    * @param  map  微信返回的参数
    * @return v
    * @Description:  校验签名
    */
   public Boolean checkSign (Map<String, String> map, String privateKey) {
      String sign = map.get("sign");
      map.remove("sign");
      String newSign = null;
      try {
         //重新加密 获取加密的签名
         newSign = WXPayUtil.generateSignature(map, privateKey);
      }catch (Exception e){
         logger.error("重新加密签名错误," , e);
      }
      if (sign.equals(newSign)) {
         logger.info("验签完毕,  签名成功~~~!!!!");
         return true;
      }
      logger.info("验签完毕,  签名错误~~~!!!!");
      return false;
   }

   /**
    * wuqiangfu special annotation
    *
    * @param  base64Data  需要解密的数据
    * @param password 微信密钥
    * @return v
    * @Description:  解密退款回调的数据
    */
   public String decryptData(String base64Data,String password) {
      try {
         Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
         SecretKeySpec key = new SecretKeySpec(mD5(password).toLowerCase().getBytes(), "AES");
         cipher.init(Cipher.DECRYPT_MODE, key);
         byte[] decode = Base64Utils.decodeFromString(base64Data);
         byte[] doFinal = cipher.doFinal(decode);
         return new String(doFinal, StandardCharsets.UTF_8);
      }catch (Exception e) {
         logger.error("解密确认微信退款异常: ,", e);
         throw new ApplicationException(CodeType.SERVICE_ERROR);
      }
   }

   /**
    * wuqiangfu special annotation
    *
    * @param  input 需要解析的数据
    * @return v
    * @Description:  md5解析
    */
   private String mD5(String input) {
      MessageDigest md5;
      try {
         md5 = MessageDigest.getInstance("MD5");
      } catch (Exception e) {
         logger.error("md5解析失败,", e);
         return "";
      }
      char[] charArray = input.toCharArray();
      byte[] byteArray = new byte[charArray.length];
      for (int i = 0; i < charArray.length; i++) {
         byteArray[i] = (byte) charArray[i];
      }
      byte[] md5Bytes = md5.digest(byteArray);
      StringBuilder hexValue = new StringBuilder();
      for (byte md5Byte : md5Bytes) {
         int val = ((int) md5Byte) & 0xff;
         if (val < 16) {
            hexValue.append("0");
         }
         hexValue.append(Integer.toHexString(val));
      }
      return hexValue.toString();
   }

   /**
    * wuqiangfu special annotation
    *
    * @param  url 调用地址
    * @param certUrl 证书地址
    * @param mchId 商户id
    * @param xml 参数xml
    * @return v
    * @Description:  通过证书进行调用微信接口
    */
   private String doPostSsl(String url, String xml, String mchId, String certUrl) throws Exception {
      // 证书
      char[] password = mchId.toCharArray();
      //读取证书
      InputStream certStream = new FileInputStream(certUrl);
      KeyStore ks = KeyStore.getInstance("PKCS12");
      ks.load(certStream, password);
      // 实例化密钥库 & 初始化密钥工厂
      KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
      kmf.init(ks, password);
      // 创建 SSLContext
      SSLContext sslContext = SSLContext.getInstance("TLS");
      sslContext.init(kmf.getKeyManagers(), null, new SecureRandom());
      SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(
            sslContext,
            new String[]{"TLSv1"},
            null,
            new DefaultHostnameVerifier());
      BasicHttpClientConnectionManager connManager = new BasicHttpClientConnectionManager(
            RegistryBuilder.<ConnectionSocketFactory>create()
                  .register("http", PlainConnectionSocketFactory.getSocketFactory())
                  .register("https", sslConnectionSocketFactory)
                  .build(), null, null, null);
      CloseableHttpClient httpClient;
      CloseableHttpResponse httpResponse = null;
      // 创建httpClient实例
      httpClient = HttpClients.custom().setConnectionManager(connManager).build();
      // 创建httpPost远程连接实例
      HttpPost httpPost = new HttpPost(url);
      // 配置请求参数实例
      // 设置连接主机服务超时时间
      RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(35000)
            // 设置连接请求超时时间
            .setConnectionRequestTimeout(35000)
            // 设置读取数据连接超时时间
            .setSocketTimeout(60000)
            .build();
      // 为httpPost实例设置配置
      httpPost.setConfig(requestConfig);
      // 设置请求头
      httpPost.addHeader("Content-Type", "text/xml");
      httpPost.addHeader("User-Agent", "WXPAYSDK_VERSION" + " " + mchId);
      // 封装post的JSON请求参数
      httpPost.setEntity(new StringEntity(xml, "UTF-8"));
      try {
         // httpClient对象执行post请求,并返回响应参数对象
         httpResponse = httpClient.execute(httpPost);
         // 从响应对象中获取响应内容
         HttpEntity entity = httpResponse.getEntity();
         return EntityUtils.toString(entity,"utf-8");
      } catch (Exception e) {
         logger.error("请求微信服务器异常,", e);
         throw new ApplicationException(CodeType.SERVICE_ERROR);
      } finally {
         // 关闭资源
         if (null != httpResponse) {
            try {
               httpResponse.close();
            } catch (IOException e) {
               logger.error("关闭流失败,", e);
            }
         }
         if (null != httpClient) {
            try {
               httpClient.close();
            } catch (IOException e) {
               logger.error("关闭流失败,", e);
            }
         }
      }
   }

   /**
    * wuqiangfu special annotation
    *
    * @return v
    * @Description:  请求并得到返回结果--POST请求
    */
   private String httpsRequest(String requestUrl, String output) {
      try {
         URL url = new URL(requestUrl);
         HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
         connection.setDoOutput(true);
         connection.setDoInput(true);
         connection.setUseCaches(false);
         connection.setRequestMethod("POST");
         if (null != output) {
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(output.getBytes(StandardCharsets.UTF_8));
            outputStream.close();
         }
         // 从输入流读取返回内容
         InputStream inputStream = connection.getInputStream();
         InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
         BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
         String str;
         StringBuilder buffer = new StringBuilder();
         while ((str = bufferedReader.readLine()) != null) {
            buffer.append(str);
         }
         bufferedReader.close();
         inputStreamReader.close();
         inputStream.close();
         connection.disconnect();
         return buffer.toString();
      } catch (Exception ex) {
         ex.printStackTrace();
      }
      return "";
   }

}
