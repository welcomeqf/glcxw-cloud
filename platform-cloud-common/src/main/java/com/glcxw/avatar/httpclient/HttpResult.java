package com.glcxw.avatar.httpclient;

import lombok.Data;

import java.io.Serializable;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.njll.iep.core.ai.httpclient
 * @FileName:       HttpResult.java
 * @ClassName:      HttpResult
 * @Description:    响应的结果封装
 * @Author:         wuqiangfu
 * @CreateDate:     2020/12/9 14:42
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2020/12/9 14:42
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
@Data
public class HttpResult implements Serializable {

    /**
     * 响应的状态码
     */
    private Integer code;

    /**
     * 响应的响应体
     */
    private String body;
}
