package com.funtl.hello.spring.cloud.alibaba.rocketmq.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

/**
 * @Author : YeLei
 * @Date : 2021/3/21 21:12
 * @Version : 1.0
 */
@SpringBootApplication
@EnableBinding({ Source.class})
public class RocketMqProviderApplication implements CommandLineRunner {

    @Autowired
    private MessageChannel output;

    public static void main(String[] args) {
        SpringApplication.run(RocketMqProviderApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("hello rocketMQ!");
        output.send(MessageBuilder.withPayload("hello rocketMQ!").build());
    }
}
