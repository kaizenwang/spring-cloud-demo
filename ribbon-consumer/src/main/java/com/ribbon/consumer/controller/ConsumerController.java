package com.ribbon.consumer.controller;

import com.ribbon.consumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by kaizen on 2018/3/23.
 */
@RestController
public class ConsumerController {
    @Autowired
    HelloService helloService;

    @RequestMapping(value = "/ribbon-consumer", method = GET)
    public String helloConsumer(){
        return helloService.helloService();
    }
}
