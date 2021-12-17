package com.glcxw.configure.mybatis;

import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**     
 * chengyangbing special annotation
 * @Package:      com.yadea.avatar.cloud.configure.mybatis
 * @FileName:     MybatisConfiguration.java
 * @ClassName:    MybatisConfiguration     
 * @Description:  Mybatis 配置
 * @Author:       chengyangbing    
 * @CreateDate:   2021/2/28 6:55 下午     
 * @UpdateUser:   chengyangbing     
 * @UpdateDate:   2021/2/28 6:55 下午     
 * @UpdateRemark: 说明本次修改内容    
 * @Version:      v1.0   
 */
@Configuration
public class MybatisConfiguration {

    @Autowired(required = false)
    ISqlParser sqlParser;

    /**
     * Annotated function annotation Hand
     *
     * @param
     * @return v
     * @throws
     * @Title:
     * @Description: mybatis-plus分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setDialectType("mysql");
        if (sqlParser != null) {
            paginationInterceptor.setSqlParser(sqlParser);
        }
        return paginationInterceptor;
    }

}
