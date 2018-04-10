package com.feign.consumer.controller;

import com.feign.consumer.service.HelloService;
import com.feign.consumer.service.RefactorHelloService;
import com.feign.consumer.service.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by kaizen on 2018/4/8.
 */
@RestController
public class ConsumerController {

    @Autowired
    HelloService helloService;

    @Autowired
    RefactorHelloService refactorHelloService;

    @RequestMapping(value = "/feign-consumer", method = GET)
    public String helloConsumer() {
        return helloService.hello();
    }

    @RequestMapping(value = "/feign-consumer2", method = GET)
    public String helloConsumer2() {
        StringBuilder sb = new StringBuilder();
        sb.append(helloService.hello()).append("\n");
        sb.append(helloService.hello("DIDI")).append("\n");
        sb.append(helloService.hello("DIDI", 30)).append("\n");
        sb.append(helloService.hello(new User("DIDI", 30))).append("\n");
        return sb.toString();
    }

    @RequestMapping(value = "/feign-consumer3", method = GET)
    public String helloConsumer3() {
        StringBuilder sb = new StringBuilder();
        sb.append(refactorHelloService.hello("MIMI")).append("\n");
        sb.append(refactorHelloService.hello("MIMI", 30)).append("\n");
        sb.append(refactorHelloService.hello(new com.hello.service.api.User("MIMI", 20))).append("\n");
        return sb.toString();
    }
}
