package com.rongda.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.rongda.springcloud.entities.CommonResult;
import com.rongda.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author lunrongda
 * @create 2021-07-04 17:11
 */
@RestController
@Slf4j
public class CircleBreakerController {

    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/fallback/{id}")
    @SentinelResource(value = "fallback") //没有配置
    public CommonResult<Payment> fallback(@PathVariable("id") Long id){
        CommonResult result = restTemplate.getForObject(serverURL + "/paymentSQL/" + id, CommonResult.class, id);

        if(id == 4){
            throw new IllegalArgumentException("IllegalArgumentException, 非法参数异常......");

        } else if(result.getData() == null){
            throw new NullPointerException("NullPointerException, 该ID没有对应记录，空指针异常.");
        }

        return result;
    }

}
