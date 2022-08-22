package com.mashibing.remote;

import com.mashibing.dto.DriverUser;
import com.mashibing.dto.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Auther: tutu
 * @Date: 2022/8/22 - 08 - 22 - 21:49
 * @Description: com.mashibing.remote
 * @version: 1.0
 */
@FeignClient("service-driver-user")
public interface ServiceDriverUserClient {

    @RequestMapping(method = RequestMethod.PUT,value = "/user")
    public ResponseResult updateUser(@RequestBody DriverUser driverUser);
}
