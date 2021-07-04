package com.rongda.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.rongda.springcloud.entities.CommonResult;

/**
 * @author lunrongda
 * @create 2021-07-04 13:58
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception){
        return new CommonResult(441, "按客户自定义，global handlerException ---> 1");
    }

    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult(442, "按客户自定义，global handlerException ---> 2");
    }

}
