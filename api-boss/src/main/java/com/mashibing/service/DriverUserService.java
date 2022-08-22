package com.mashibing.service;

import com.mashibing.dto.DriverUser;
import com.mashibing.dto.ResponseResult;
import com.mashibing.remote.ServiceDriverUserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: tutu
 * @Date: 2022/8/22 - 08 - 22 - 20:53
 * @Description: com.mashibing.service
 * @version: 1.0
 */
@Service
public class DriverUserService {

    @Autowired
    private ServiceDriverUserClient serviceDriverUserClient;


    public ResponseResult addDriverUser(DriverUser driverUser){

        return serviceDriverUserClient.addDriverUser(driverUser);
    }

}
