package com.mars.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

    //@Configuration 相当于 spring中的 application.xml
    @Bean
    @LoadBalanced //ribbon的负载均衡注解
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}