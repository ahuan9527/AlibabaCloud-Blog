package org.foon.provider.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description <What does this class do>
 * @DATE 2020/9/23 10:56
 * @Author ahuan
 * @ProjectName AlibabaCloud-Blog
 * @Email a1875884755@gmail.com
 * @Version 1.0
 */
@RestController
public class EchoController {
    private static final Logger log = LoggerFactory.getLogger(EchoController.class);

    @GetMapping(value = "/echo/{str}")
    public String echo(@PathVariable String str){
        log.info("hellow nacos,I'm very happy!");
        return "Hellow Nacos "+str;
    }
}
