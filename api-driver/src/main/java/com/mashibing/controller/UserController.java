package com.mashibing.controller;

import com.mashibing.dto.DriverUser;
import com.mashibing.dto.ResponseResult;
import com.mashibing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Driver;

/**
 * @Auther: tutu
 * @Date: 2022/8/22 - 08 - 22 - 21:47
 * @Description: com.mashibing.controller
 * @version: 1.0
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PutMapping("/user")
    public ResponseResult updateUser(@RequestBody DriverUser driverUser){
        return userService.updateUser(driverUser);
    }
}
