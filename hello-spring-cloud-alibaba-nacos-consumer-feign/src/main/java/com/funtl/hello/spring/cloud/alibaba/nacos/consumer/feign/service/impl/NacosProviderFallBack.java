package com.funtl.hello.spring.cloud.alibaba.nacos.consumer.feign.service.impl;

import com.funtl.hello.spring.cloud.alibaba.nacos.consumer.feign.service.NacosProviderService;
import org.springframework.stereotype.Component;

/**
 * @Author : YeLei
 * @Date : 2021/3/14 14:38
 * @Version : 1.0
 */
@Component
public class NacosProviderFallBack implements NacosProviderService {

    @Override
    public String testNacosProvider(String message) {
        return "网络异常，请检查你的网络！";
    }
}
