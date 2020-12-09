package org.foon.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

import javax.swing.*;

/**
 * @Description <What does this class do>
 * @DATE 2020/9/23 11:19
 * @Author ahuan
 * @ProjectName AlibabaCloud-Blog
 * @Email a1875884755@gmail.com
 * @Version 1.0
 */
@SpringBootApplication
public class ApplicationNacosConsumer {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationNacosConsumer.class);
    }

}
