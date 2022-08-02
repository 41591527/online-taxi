package com.mashibing.apipassenger.service;

import com.mashibing.apipassenger.remote.ServiceVerificationClient;
import com.mashibing.dto.ResponseResult;
import com.mashibing.response.NumberCodeResponse;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

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

    //乘客验证码的前缀
    private String verificationCodePrefix = "passenger-verification-code-";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public ResponseResult generatorCode(String passengerPhone){
        //调用验证码服务，获取验证码
        ResponseResult<NumberCodeResponse> numberCodeResponse = serviceVerificationClient.getNumberCode(6);
        int numberCode = numberCodeResponse.getData().getNumberCode();

        System.out.println("remote number code: " + numberCode);


        //存入redis

        //key,value,过期时间
        String key = verificationCodePrefix + passengerPhone;
        //存入redis
        stringRedisTemplate.opsForValue().set(key,numberCode+"",2, TimeUnit.MINUTES);

        //通过短信服务商，将对应的验证码发送到手机上。


        return ResponseResult.success("");
    }
}
