package com.mashibing.controller;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: tutu
 * @Date: 2022/8/3 - 08 - 03 - 21:50
 * @Description: com.mashibing.controller
 * @version: 1.0
 */
@RestController
public class TestController {
    @GetMapping
    public String test(){
        return "service-passenger-user";
    }
}
