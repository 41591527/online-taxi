package com.mashibing.controller;

import com.mashibing.dto.ResponseResult;
import com.mashibing.response.NumberCodeResponse;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: tutu
 * @Date: 2022/7/29 - 07 - 29 - 20:23
 * @Description: com.mashibing.controller
 * @version: 1.0
 */
@RestController
public class NumberCodeController {

    @GetMapping("/numberCode/{size}")
    public ResponseResult numberCode(@PathVariable("size") int size){

        // 生成验证码
        double mathRandom = (Math.random()*9 + 1) * (Math.pow(10,size-1));
        int resultInt = (int) mathRandom;

        NumberCodeResponse response = new NumberCodeResponse();
        response.setNumberCode(resultInt);
        System.out.println("src code: " + resultInt);
        return ResponseResult.success(response);
    }
}
