package com.rongda.springcloud.service.impl;

import com.rongda.springcloud.dao.PaymentDao;
import com.rongda.springcloud.entities.Payment;
import com.rongda.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lunrongda
 * @create 2020-06-27 11:29
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
