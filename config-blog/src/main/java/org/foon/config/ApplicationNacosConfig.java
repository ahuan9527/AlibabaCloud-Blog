package org.foon.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Description <What does this class do>
 * @DATE 2020/9/23 16:09
 * @Author ahuan
 * @ProjectName AlibabaCloud-Blog
 * @Email a1875884755@gmail.com
 * @Version 1.0
 */
@SpringBootApplication
public class ApplicationNacosConfig {
    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(ApplicationNacosConfig.class, args);
       while (true){
           String name = applicationContext.getEnvironment().getProperty("name");
           String config = applicationContext.getEnvironment().getProperty("config");
           System.out.println(name+","+config);
           TimeUnit.SECONDS.sleep(1);
       }


    }
}
