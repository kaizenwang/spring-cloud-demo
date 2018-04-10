package com.feign.consumer.service;

import com.hello.service.api.HelloService;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by kaizen on 2018/4/9.
 */
@FeignClient(value = "HELLO-SERVICE")
public interface RefactorHelloService extends HelloService {
}
