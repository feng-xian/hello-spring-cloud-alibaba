package com.funtl.hello.spring.cloud.alibaba.nacos.consumer.feign.service;

import com.funtl.hello.spring.cloud.alibaba.nacos.consumer.feign.service.impl.NacosProviderFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author : YeLei
 * @Date : 2021/3/14 11:06
 * @Version : 1.0
 */
@FeignClient(value = "nacos-provider/nacosProvider", fallback = NacosProviderFallBack.class)
public interface NacosProviderService {

    @GetMapping("/nacosProvider")
    String testNacosProvider(@RequestParam("message") String message);

}
