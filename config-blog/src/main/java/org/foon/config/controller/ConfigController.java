package org.foon.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description <What does this class do>
 * @DATE 2020/9/23 18:24
 * @Author ahuan
 * @ProjectName AlibabaCloud-Blog
 * @Email a1875884755@gmail.com
 * @Version 1.0
 */
@RestController
@RefreshScope
public class ConfigController {

    @Value("${name}")
    private String name;
    @Value("${config}")
    private String config;

    @GetMapping("/nacos/properties")
    public String getProperties(){

        return name+","+config;
    }

}
