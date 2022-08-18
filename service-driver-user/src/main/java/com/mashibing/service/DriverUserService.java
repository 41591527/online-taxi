package com.mashibing.service;

import com.mashibing.dto.DriverUser;
import com.mashibing.dto.ResponseResult;
import com.mashibing.mapper.DriverUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.Oneway;

/**
 * @Auther: tutu
 * @Date: 2022/8/18 - 08 - 18 - 21:00
 * @Description: com.mashibing.service
 * @version: 1.0
 */
@Service
public class DriverUserService {
    @Autowired
    private DriverUserMapper driverUserMapper;


    public ResponseResult testGetDriverUser(){

        DriverUser driverUser = driverUserMapper.selectById(1);
        return ResponseResult.success(driverUser);
    }
}
