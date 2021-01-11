package com.rongda.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author lunrongda
 * @create 2020-07-06 22:29
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
//    @LoadBalanced  //使用@LoadBalanced注解赋予RestTemplate负载均衡的能力
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
/*
    applicationContext.xml  <bean id="" class="">
 */
