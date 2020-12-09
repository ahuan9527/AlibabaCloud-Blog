package org.foon.sentinel.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.EntryType;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.adapter.reactor.SentinelReactorTransformer;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description <What does this class do>
 * @DATE 2020/9/24 12:20
 * @Author ahuan
 * @ProjectName AlibabaCloud-Blog
 * @Email a1875884755@gmail.com
 * @Version 1.0
 */
@RestController
public class SentinelController {

    @GetMapping("/sentinel")
    public String sentinelC(){
        return "Hello Sentinel!";
    }

  /*  @GetMapping("/mono")
    @SentinelResource("hello1")
    public Mono<String> mono() {
        return Mono.just("simple string")
                .transform(new SentinelReactorTransformer<>("otherResourceName"));
    }*/

    @GetMapping("/testSentinel")
    public @ResponseBody
    String testSentinel() {
        String resourceName = "testSentinel";
        Entry entry = null;
        String retVal;
        try{
            entry = SphU.entry(resourceName, EntryType.IN);
            retVal = "passed";
        }catch(BlockException e){
            retVal = "blocked";
        }finally {
            if(entry!=null){
                entry.exit();
            }
        }
        return retVal;
    }
}
