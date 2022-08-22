package com.mashibing.service;

import com.mashibing.dto.DriverUser;
import com.mashibing.dto.ResponseResult;
import com.mashibing.remote.ServiceDriverUserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Auther: tutu
 * @Date: 2022/8/22 - 08 - 22 - 21:48
 * @Description: com.mashibing.service
 * @version: 1.0
 */
@Service
public class UserService {

    @Autowired
    private ServiceDriverUserClient serviceDriverUserClient;

    public ResponseResult updateUser(@RequestBody DriverUser driverUser){
        return serviceDriverUserClient.updateUser(driverUser);
    }
}
