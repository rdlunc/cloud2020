package com.rongda.springcloud.service;

import com.rongda.springcloud.entities.Payment;

/**
 * @author lunrongda
 * @create 2020-06-27 11:28
 */
public interface PaymentService {

    //CURD ....

    public int create(Payment payment);

    public Payment getPaymentById(Long id);

}
