package com.glcxw.avatar.handle;

import com.google.common.collect.Maps;
import lombok.Getter;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Map;

/**     
 * chengyangbing special annotation
 * @Package:      com.yadea.avatar.gateway.handler
 * @FileName:     GatewayResponseEntity.java
 * @ClassName:    GatewayResponseEntity     
 * @Description:  网关响应报文
 * @Author:       chengyangbing    
 * @CreateDate:   2021/3/1 11:18 上午     
 * @UpdateUser:   chengyangbing     
 * @UpdateDate:   2021/3/1 11:18 上午     
 * @UpdateRemark: 说明本次修改内容    
 * @Version:      v1.0   
 */
public class GatewayResponseEntity {

    @Getter
    private Integer code;

    @Getter
    private Boolean success;

    @Getter
    private String message;

    @Getter
    private Object result;

    private GatewayResponseEntity(Integer code, Boolean success, String message, Object result) {
        this.code = code;
        this.success = success;
        this.message = message;
        this.result = result;
    }

    public Map<String, Object> toMapResult() {
        Map<String, Object> map = Maps.newHashMap();
        //获取指定类（Person）的BeanInfo 对象
        BeanInfo beanInfo = null;
        try {
            beanInfo = Introspector.getBeanInfo(this.getClass(), Object.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        //获取所有的属性描述器
        PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor pd : pds) {
            String key = pd.getName();
            Method getter = pd.getReadMethod();
            Object value = null;
            try {
                value = getter.invoke(this);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            map.put(key, value);
        }
        return map;
    }

    public static GatewayResponseEntity result(Integer code, String message) {
        return new GatewayResponseEntity(code, true, message,null);
    }

    public static GatewayResponseEntity result(Integer code, String message, Object result) {
        return new GatewayResponseEntity(code, true, message,result);
    }

    public static GatewayResponseEntity error(Integer code, String message) {
        return new GatewayResponseEntity(code, false, message,null);
    }

    public static GatewayResponseEntity error(Integer code, String message, Object result) {
        return new GatewayResponseEntity(code, false, message,result);
    }
}
