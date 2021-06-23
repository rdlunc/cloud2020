package com.rongda.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lunrongda
 * @create 2021-06-23 8:53
 */
@EnableDiscoveryClient
@SpringBootApplication
public class NacosConfigClientMain {
    public static void main(String[] args) {
        SpringApplication.run(NacosConfigClientMain.class, args);
    }
}
