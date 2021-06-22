package com.rongda.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author lunrongda
 * @create 2021-06-22 10:00
 */
@Slf4j
@RestController
public class OrderNacosController {

    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id){
        return restTemplate.getForObject(serverURL + "/payment/nacos/" + id, String.class);
    }

}
