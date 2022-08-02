package com.mashibing.apipassenger.remote;

import com.mashibing.dto.ResponseResult;
import com.mashibing.response.NumberCodeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Auther: tutu
 * @Date: 2022/8/2 - 08 - 02 - 20:37
 * @Description: com.mashibing.apipassenger.remote
 * @version: 1.0
 */
@FeignClient("service-verificationcode")
public interface ServiceVerificationClient {

    @RequestMapping(method = RequestMethod.GET,value = "/numberCode/{size}}")
    ResponseResult<NumberCodeResponse> getNumberCode(@PathVariable("size") int size);
}
