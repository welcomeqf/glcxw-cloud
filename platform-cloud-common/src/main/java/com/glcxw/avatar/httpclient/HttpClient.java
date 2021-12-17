package com.glcxw.avatar.httpclient;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.njll.iep.core.ai.httpclient
 * @FileName:       HttpClient.java
 * @ClassName:      HttpClient
 * @Description:    httpClient调用
 * @Author:         wuqiangfu
 * @CreateDate:     2020/12/9 14:28
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2020/12/9 14:28
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
@Component
public class HttpClient {

    private static CloseableHttpClient httpClient;

    public HttpClient() {
        //打开浏览器
        httpClient = HttpClients.createDefault();
    }

    /**
     * wuqiangfu special annotation
     *
     * @param  url  请求路径
     * @param jsonInfo 请求参数
     * @param token  请求token
     * @return v
     * @Description:  post请求
     */
    public HttpResult post(String url, String jsonInfo, String token) throws Exception {
        // 声明httpPost请求
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Content-Type", "application/json");
        String charSet = "UTF-8";
        StringEntity entity = new StringEntity(jsonInfo, charSet);
        httpPost.setEntity(entity);
        httpPost.setHeader("authorization",token);
        // 使用HttpClient发起请求，返回response
        CloseableHttpResponse response = httpClient.execute(httpPost);
        // 解析response封装返回对象httpResult
        HttpResult httpResult = new HttpResult();
        // 解析数据封装HttpResult
        if (response.getEntity() != null) {
            httpResult.setCode(response.getStatusLine().getStatusCode());
            httpResult.setBody(EntityUtils.toString(response.getEntity(),charSet));
        } else {
            httpResult.setCode(response.getStatusLine().getStatusCode());
        }
        // 返回结果
        return httpResult;
    }

    /**
     * wuqiangfu special annotation
     *
     * @param  url  请求路径
     * @param jsonInfo 请求参数
     * @param token  请求token
     * @return v
     * @Description:  put请求
     */
    public HttpResult put(String url, String jsonInfo, String token) throws Exception {
        // 声明httpPost请求
        HttpPut httpPut = new HttpPut(url);
        String charSet = "UTF-8";
        StringEntity entity = new StringEntity(jsonInfo, charSet);
        httpPut.setEntity(entity);
        httpPut.setHeader("authorization",token);
        httpPut.setHeader("Content-Type", "application/json");
        // 解析response封装返回对象httpResult
        HttpResult httpResult = new HttpResult();
        // 使用HttpClient发起请求，返回response
        CloseableHttpResponse response = httpClient.execute(httpPut);
        // 解析数据封装HttpResult
        if (response.getEntity() != null) {
            httpResult.setCode(response.getStatusLine().getStatusCode());
            httpResult.setBody(EntityUtils.toString(response.getEntity(),charSet));
        } else {
            httpResult.setCode(response.getStatusLine().getStatusCode());
        }
        // 返回结果
        return httpResult;
    }

    /**
     * wuqiangfu special annotation
     *
     * @param  url  请求路径
     * @param token  请求token
     * @return v
     * @Description:  delete请求
     */
    public HttpResult delete (String url, String token) {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpDelete delete = new HttpDelete(url);
        try {
            if (!StringUtils.isEmpty(token)) {
                //自定义header头，用于token验证使用
                delete.addHeader("Authorization", token);
                delete.addHeader("Content-Type", "application/json");
                HttpResponse response = httpClient.execute(delete);
                if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                    //返回json格式
                    HttpResult res = new HttpResult();
                    if (response.getEntity() != null) {
                        res.setCode(response.getStatusLine().getStatusCode());
                        res.setBody(EntityUtils.toString(response.getEntity(),"UTF-8"));

                    } else {
                        res.setCode(response.getStatusLine().getStatusCode());
                        res.setBody("调用错误");
                    }
                    return res;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }


}
