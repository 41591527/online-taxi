package com.mashibing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mashibing.mapper")
public class ServiceDriverUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceDriverUserApplication.class, args);
    }

}
