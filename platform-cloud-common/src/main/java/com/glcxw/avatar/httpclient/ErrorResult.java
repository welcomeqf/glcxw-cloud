package com.glcxw.avatar.httpclient;


import lombok.Data;

/**
 * wuqiangfu special annotation
 *
 * @Package:        com.njll.iep.core.ai.httpclient
 * @FileName:       ErrorResult.java
 * @ClassName:      ErrorResult
 * @Description:    错误结果
 * @Author:         wuqiangfu
 * @CreateDate:     2020/12/9 14:41
 * @UpdateUser:     wuqiangfu
 * @UpdateDate:     2020/12/9 14:41
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
@Data
public class ErrorResult {

    private String msg;

    private Integer code;

}
