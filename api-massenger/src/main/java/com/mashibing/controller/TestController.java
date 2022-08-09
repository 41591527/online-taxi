package com.mashibing.controller;

import com.mashibing.dto.ResponseResult;
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

    /**
     * 需要token的方法
     * @return
     */
    @GetMapping("/authTest")
    public ResponseResult authTest(){
        return ResponseResult.success("auth test");
    }

    /**
     * 无需token的方法
     * @return
     */
    @GetMapping("/noauthTest")
    public ResponseResult noauthTest(){
        return ResponseResult.success("noauth test");
    }
}
