package com.funtl.hello.spring.cloud.alibaba.nacos.consumer.feign.controller;

import com.funtl.hello.spring.cloud.alibaba.nacos.consumer.feign.service.NacosProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : YeLei
 * @Date : 2021/3/14 11:09
 * @Version : 1.0
 */
@RestController
@RequestMapping("nacosFeign")
public class NacosProviderController {

    @Value("${spring.application.name}")
    private String serviceName;

    @Autowired
    private NacosProviderService nacosProviderService;

    @GetMapping("/requestFeign")
    public String requestFeign(){
        String result = nacosProviderService.testNacosProvider(serviceName);
        return result;
    }

}
