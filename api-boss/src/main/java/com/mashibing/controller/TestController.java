package com.mashibing.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: tutu
 * @Date: 2022/8/22 - 08 - 22 - 20:44
 * @Description: com.mashibing.controller
 * @version: 1.0
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String test(){
        return "api-boss";
    }
}
