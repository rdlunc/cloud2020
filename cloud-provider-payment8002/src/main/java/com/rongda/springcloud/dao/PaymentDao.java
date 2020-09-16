package com.rongda.springcloud.dao;

import com.rongda.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author lunrongda
 * @create 2020-06-24 22:28
 */
@Mapper
public interface PaymentDao {
    //CURD ....

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
