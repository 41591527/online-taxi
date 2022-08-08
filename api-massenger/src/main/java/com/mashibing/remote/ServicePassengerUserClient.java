package com.mashibing.remote;

import com.mashibing.dto.ResponseResult;
import com.mashibing.request.VerificationCodeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Auther: tutu
 * @Date: 2022/8/8 - 08 - 08 - 20:47
 * @Description: com.mashibing.remote
 * @version: 1.0
 */
@FeignClient("service-passenger-user")
public interface ServicePassengerUserClient {

    @RequestMapping(method = RequestMethod.POST, value = "/user")
    public ResponseResult loginOrRegister(@RequestBody VerificationCodeDTO verificationCodeDTO);
}
