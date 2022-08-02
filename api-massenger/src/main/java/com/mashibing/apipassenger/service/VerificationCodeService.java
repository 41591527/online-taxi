package com.mashibing.apipassenger.service;

import com.mashibing.apipassenger.remote.ServiceVerificationClient;
import com.mashibing.dto.ResponseResult;
import com.mashibing.response.NumberCodeResponse;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: tutu
 * @Date: 2022/7/27 - 07 - 27 - 21:34
 * @Description: com.mashibing.apipassenger.service
 * @version: 1.0
 */
@Service
public class VerificationCodeService {

    @Autowired
    private ServiceVerificationClient serviceVerificationClient;

    public String generatorCode(String passengerPhone){
        //调用验证码服务，获取验证码
        System.out.println("调用验证码服务，获取验证码");
        ResponseResult<NumberCodeResponse> numberCodeResponse = serviceVerificationClient.getNumberCode(6);
        int numberCode = numberCodeResponse.getData().getNumberCode();

        System.out.println("remote number code: " + numberCode);

        //存入redis
        System.out.println("存入redis");

        //返回值
        JSONObject result = new JSONObject();
        result.put("code",1);
        result.put("message","success");

        return result.toString();
    }
}
