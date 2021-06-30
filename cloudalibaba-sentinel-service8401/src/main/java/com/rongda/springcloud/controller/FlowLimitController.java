package com.rongda.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

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
        //暂停1秒
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "------------> testB";
    }

}
