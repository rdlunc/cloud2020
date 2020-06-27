package com.rongda.springcloud.controller;

import com.rongda.springcloud.entities.CommonResult;
import com.rongda.springcloud.entities.Payment;
import com.rongda.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lunrongda
 * @create 2020-06-27 11:36
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(Payment payment){
        int result = paymentService.create(payment);
        log.info("====>插入结果： " + result);

        if(result > 0){
            return new CommonResult(200,"插入成功",result);
        }
        else {
            return new CommonResult(500,"插入失败",result);
        }
    }

    @GetMapping(value = "/payement/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment result = paymentService.getPaymentById(id);
        log.info("====>查询结果： " + result);

        if(result != null){
            return new CommonResult(200,"查询成功",result);
        }
        else{
            return new CommonResult(500,"没有对应记录，查询ID：" + id, result);
        }
    }

}
