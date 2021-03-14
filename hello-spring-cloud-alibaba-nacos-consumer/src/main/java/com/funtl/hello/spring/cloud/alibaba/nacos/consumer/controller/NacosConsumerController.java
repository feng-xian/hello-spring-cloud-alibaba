package com.funtl.hello.spring.cloud.alibaba.nacos.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author : YeLei
 * @Date : 2021/3/14 10:21
 * @Version : 1.0
 */
@RestController
@RequestMapping("/consumer")
public class NacosConsumerController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${spring.application.name}")
    private String serverName;


    @GetMapping("/appName")
    public String linkConsumer(){
        //使用 LoadBalanceClient 和 RestTemplate 结合的方式来访问
        ServiceInstance serviceInstance = loadBalancerClient.choose("nacos-provider");
        String url = String.format("http://%s:%s/nacosProvider/nacosProvider?message=%s", serviceInstance.getHost(), serviceInstance.getPort(),serverName);
        System.out.println("url--------->"+url);
        return restTemplate.getForObject(url, String.class);
    }

}
