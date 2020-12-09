package org.foon.blog.login.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Description <What does this class do>
 * @DATE 2020/9/28 12:02
 * @Author ahuan
 * @ProjectName AlibabaCloud-Blog
 * @Email a1875884755@gmail.com
 * @Version 1.0
 */
@Configuration
@EnableTransactionManagement
@MapperScan("org.foon.blog.login.mapper")
public class MyBatisPlus {
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        return paginationInterceptor;
    }
}
