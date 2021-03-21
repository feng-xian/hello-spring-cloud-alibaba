package com.funtl.hello.spring.cloud.alibaba.nacos.provider.controller;

import org.springframework.beans.ConfigurablePropertyAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
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

    @Autowired
    private ConfigurableApplicationContext configurableApplicationContext;

    @GetMapping("/nacosProvider")
    public String testNacosProvider(String message){
        String name = configurableApplicationContext.getEnvironment().getProperty("user.name");
        return "hello nacos your name is " + message + " and I am from " +
                ""+port+" and My name is "+ name;
    }


}
