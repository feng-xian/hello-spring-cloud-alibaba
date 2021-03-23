package com.funtl.hello.spring.cloud.alibaba.rocketmq.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * @Author : YeLei
 * @Date : 2021/3/22 20:15
 * @Version : 1.0
 */
@SpringBootApplication
@EnableBinding({Sink.class })
public class RocketMqConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RocketMqConsumerApplication.class, args);
    }

    @StreamListener("input")
    public void receiveInput1(String receiveMsg) {
        System.out.println("<---------hello------->");
        System.out.println("input receive: " + receiveMsg);
    }

}
