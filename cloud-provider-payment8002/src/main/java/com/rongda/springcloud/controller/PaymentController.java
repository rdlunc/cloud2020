package com.rongda.springcloud.controller;

import com.rongda.springcloud.entities.CommonResult;
import com.rongda.springcloud.entities.Payment;
import com.rongda.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author lunrongda
 * @create 2020-06-27 11:36
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("====>插入结果： " + result);

        if(result > 0){
            return new CommonResult(200,"插入成功, serverPort: " + serverPort, result);
        }
        else {
            return new CommonResult(500,"插入失败",result);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment result = paymentService.getPaymentById(id);
        log.info("====>查询结果： " + result + "\t" + "O(∩_∩)O");

        if(result != null){
            return new CommonResult(200,"查询成功, serverPort: " + serverPort, result);
        }
        else{
            return new CommonResult(500,"没有对应记录，查询ID：" + id, result);
        }
    }

}
