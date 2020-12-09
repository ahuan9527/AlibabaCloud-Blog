package org.foon.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description <启动类>
 * @DATE 2020/9/23 10:16
 * @Author ahuan
 * @ProjectName AlibabaCloud-Blog
 * @Email a1875884755@gmail.com
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ApplicationNacosProvider {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationNacosProvider.class);
    }
}
