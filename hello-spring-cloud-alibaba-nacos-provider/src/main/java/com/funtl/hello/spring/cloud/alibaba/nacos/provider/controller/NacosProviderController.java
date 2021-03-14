package com.funtl.hello.spring.cloud.alibaba.nacos.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : YeLei
 * @Date : 2021/3/11 22:03
 * @Version : 1.0
 */

@RestController
@RequestMapping("/nacosProvider")
public class NacosProviderController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/nacosProvider")
    public String testNacosProvider(String message){
        return "hello nacos your name is " + message + "and I am from "+port;
    }


}
