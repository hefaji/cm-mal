package com.xiaobaidu.mall.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author hefaji
 * @create 2017-09-14 16:19
 **/
 @Service
 //@RibbonClient(name = "CM-MALL-SERVICE", configuration = TestService.class)
public class TestService {
    @Autowired
    RestTemplate restTemplate;
    @HystrixCommand(fallbackMethod = "fallbackSearchAll")
    public String  test(){
        return restTemplate.getForObject("http://cm-mall-service/test",String.class);
    }

    private String fallbackSearchAll() {

        return "fallbackSearchAll******";

     }
}
