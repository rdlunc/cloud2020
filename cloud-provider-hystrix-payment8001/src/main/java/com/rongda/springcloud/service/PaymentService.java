package com.rongda.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author lunrongda
 * @create 2021-02-11 22:51
 */
@Service
public class PaymentService {

    /**
     * 正常访问
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id){
        return "线程池：" + Thread.currentThread().getName() + " paymentInfo_OK, id：" + id + "\t" + "O(∩_∩)O哈哈~";
    }

    /**
     * 延迟访问
     * @param id
     * @return
     */
    public String paymentInfo_TimeOut(Integer id){
        int timeNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + " paymentInfo_TimeOut, id：" + id + "\t" + "耗时" + timeNumber + "秒钟";
    }
}
