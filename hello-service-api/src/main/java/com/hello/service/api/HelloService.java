package com.hello.service.api;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by kaizen on 2018/4/9.
 */
@RequestMapping("/refactor")
public interface HelloService {

    @RequestMapping(value = "/hello4", method = GET)
    String hello(@RequestParam("name") String name);

    @RequestMapping(value = "/hello5", method = GET)
    User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @RequestMapping(value = "/hello6", method = POST)
    String hello(@RequestBody User user);
}
