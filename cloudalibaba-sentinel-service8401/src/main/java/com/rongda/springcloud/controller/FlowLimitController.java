package com.rongda.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author lunrongda
 * @create 2021-06-29 21:13
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        log.info(Thread.currentThread().getName() + "\t" + "---------> testA");
        return "------------> testA";
    }

    @GetMapping("/testB")
    public String testB(){
        //暂停1秒
//        try {
//            TimeUnit.MILLISECONDS.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return "------------> testB";
    }

    @GetMapping("/testD")
    public String testD(){
        //暂停1秒
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("=========> testD 测试RT");
        return "------------> testD";
    }

    @GetMapping("/testE")
    public String testE(){
        log.info("=========> testE 测试异常比例");

        int age = 10/0;

        return "------------> testE";
    }

    @GetMapping("/testF")
    public String testF(){
        log.info("=========> testF 测试异常数");

        int age = 10/0;

        return "------------> testF";
    }

    @GetMapping("/testHotKey")
//    @SentinelResource(value = "testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2){

        //模拟异常
        int age = 10/0;

        return "------------> testHotKey";
    }
    public String deal_testHotKey(String p1, String p2, BlockException exception){
        return "------------> deal_testHotKey, o(╥﹏╥)o"; //sentinel系统默认的提示：Blocked by Sentinel (flow limiting)
    }

}
