package com.mashibing.controller;

import com.mashibing.dto.DriverUser;
import com.mashibing.dto.ResponseResult;
import com.mashibing.service.DriverUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: tutu
 * @Date: 2022/8/22 - 08 - 22 - 20:11
 * @Description: com.mashibing.controller
 * @version: 1.0
 */
@RestController
public class UserController {

    @Autowired
    private DriverUserService driverUserService;

    @PostMapping("/users")
    public ResponseResult addUser(@RequestBody DriverUser driverUser){

        return driverUserService.addDriverUser(driverUser);
    }
}
