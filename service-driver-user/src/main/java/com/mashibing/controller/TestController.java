package com.mashibing.controller;

import com.mashibing.dto.ResponseResult;
import com.mashibing.service.DriverUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: tutu
 * @Date: 2022/8/18 - 08 - 18 - 20:50
 * @Description: com.mashibing.controller
 * @version: 1.0
 */
@RestController
public class TestController {

    @Autowired
    private DriverUserService driverUserService;

    @GetMapping("/test-db")
    public ResponseResult testDb(){
        return driverUserService.testGetDriverUser();
    }

}
