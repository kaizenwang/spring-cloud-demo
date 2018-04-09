package com.hello.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by kaizen on 2018/3/22.
 */
@RestController
public class HelloController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private Registration registration;

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/hello", method = GET)
    public String index() {
        List<ServiceInstance> list = client.getInstances(registration.getServiceId());
        if (list != null && list.size() > 0) {
            logger.info("/hello, host:" + list.get(0).getHost() + ", service_id:" + list.get(0).getServiceId());
        }
        return "Hello World";
    }

    @RequestMapping(value = "/hello1", method = GET)
    public String hello(@RequestParam String name) {
        return "Hello " + name;
    }

    @RequestMapping(value = "/hello2", method = GET)
    public User hello(@RequestHeader String name, @RequestHeader Integer age){
       return new User(name, age);
    }

    @RequestMapping(value = "/hello3", method = POST)
    public String hello(@RequestBody User user){
       return "Hello " + user.getName() + ", " + user.getAge();
    }
}
