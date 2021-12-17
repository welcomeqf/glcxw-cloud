package com.glcxw.avatar.common.domain;

import lombok.Data;
import org.springframework.util.StringUtils;

import java.io.Serializable;

/**     
 * chengyangbing special annotation
 * @Package:      org.uppeak.pck.common.domain
 * @FileName:     BaseParam.java
 * @ClassName:    BaseParam     
 * @Description:  基础的 Param 类
 * @Author:       chengyangbing    
 * @CreateDate:   2019-05-20 15:28     
 * @UpdateUser:   chengyangbing     
 * @UpdateDate:   2019-05-20 15:28     
 * @UpdateRemark: 说明本次修改内容    
 * @Version:      v1.0   
 */
@Data
public class BaseParam implements Serializable {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    /**
     * 关键字
     */
    private String keyword;

    /**
     *  当前页
     */
    private Long pageNumbers = 1L;

    /**
     * 每页显示条数
     */
    private Long countPerPages = 10L;
}
