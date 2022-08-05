package com.mashibing.service;

import com.mashibing.dto.ResponseResult;
import com.mashibing.request.VerificationCodeDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Auther: tutu
 * @Date: 2022/8/5 - 08 - 05 - 20:45
 * @Description: com.mashibing.service
 * @version: 1.0
 */
@Service
public class UserService {

    public ResponseResult loginOrRegister(String passengerPhone){

        System.out.println("user service被调用，手机号：" + passengerPhone);
        //根据手机号查询用户信息

        //判断用户信息是否存在

        //如果不存在，插入用户信息

        return ResponseResult.success();
    }
}
