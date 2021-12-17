package com.glcxw.avatar.auth.domain;

import lombok.Data;

import java.util.List;

/**
 * yeshengguang special annotation
 *
 * @Package:        com.yadea.avatar.authc.admin
 * @FileName:       BaseDetails.java
 * @ClassName:      BaseDetails
 * @Description:    基础详细数据类
 * @Author:         yeshengguang
 * @CreateDate:     2021/3/2 7:52 下午
 * @UpdateUser:     yeshengguang
 * @UpdateDate:     2021/3/2 7:52 下午
 * @UpdateRemark:   说明本次修改内容
 * @Version:        v1.0
 */
@Data
public class BaseDetails {

    /**
     * 用户编号
     */
    private String number;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户头像
     */
    private String headUrl;

    /**
     * 设备id
     */
    private String registrationId;

    /**
     * 用户角色集
     */
    private List<String> roles;

}
