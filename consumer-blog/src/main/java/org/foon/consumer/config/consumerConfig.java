package org.foon.consumer.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @Description <What does this class do>
 * @DATE 2020/9/23 11:22
 * @Author ahuan
 * @ProjectName AlibabaCloud-Blog
 * @Email a1875884755@gmail.com
 * @Version 1.0
 */
@Configuration
@Component
public class consumerConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
