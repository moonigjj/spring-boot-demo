package com.gjy.config;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName:MybatisPlusConfig
 *
 * @author ty
 * @description
 * @create 2017/7/11 14:49
 **/
@Configuration
public class MybatisPlusConfig {

    /**
     * mybatis-plus分页插件
     *
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {

        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setDialectType("mysql");
        return paginationInterceptor;
    }
}
