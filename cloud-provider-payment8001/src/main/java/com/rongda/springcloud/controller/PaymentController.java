package com.rongda.springcloud.controller;

import com.rongda.springcloud.entities.CommonResult;
import com.rongda.springcloud.entities.Payment;
import com.rongda.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
    private DiscoveryClient discoveryClient;

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
            return new CommonResult(500,"插入失败", result);
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

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        //获取服务的清单列表
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("--------> element:" + element);
        }

        //根据服务名称，获取相应的服务实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" +instance.getUri());
        }

        return this.discoveryClient;
    }

    @GetMapping(value = "payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }

}
