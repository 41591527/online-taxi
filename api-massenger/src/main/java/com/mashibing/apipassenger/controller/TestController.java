package com.mashibing.apipassenger.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: tutu
 * @Date: 2022/7/27 - 07 - 27 - 21:02
 * @Description: com.mashibing.apipassenger.controller
 * @version: 1.0
 */
@RestController
public class TestController {
    @GetMapping("/test")
    public String test(){
        return "test";
    }
}
