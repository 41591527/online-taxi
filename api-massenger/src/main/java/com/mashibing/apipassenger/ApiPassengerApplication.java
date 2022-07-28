package com.mashibing.apipassenger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Auther: tutu
 * @Date: 2022/7/27 - 07 - 27 - 21:01
 * @Description: com.mashibing.apipassenger
 * @version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ApiPassengerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiPassengerApplication.class);
    }
}
