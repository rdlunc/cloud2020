package com.rongda.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lunrongda
 * @create 2021-06-29 21:13
 */
@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        return "------------> testA";
    }

    @GetMapping("/testB")
    public String testB(){
        return "------------> testB";
    }

}
