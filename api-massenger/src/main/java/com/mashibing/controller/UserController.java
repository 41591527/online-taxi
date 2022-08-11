package com.mashibing.controller;

import com.mashibing.dto.ResponseResult;
import com.mashibing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: tutu
 * @Date: 2022/8/11 - 08 - 11 - 20:37
 * @Description: com.mashibing.controller
 * @version: 1.0
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseResult getUser(HttpServletRequest request){

        // 从http请求中获取accessToken
        String accessToken = request.getHeader("Authorization");


        return userService.getUserByAccessToken(accessToken);


    }
}
