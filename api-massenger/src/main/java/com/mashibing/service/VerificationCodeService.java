package com.mashibing.service;

import com.mashibing.remote.ServiceVerificationClient;
import com.mashibing.dto.ResponseResult;
import com.mashibing.response.NumberCodeResponse;
import com.mashibing.response.TokenResponse;
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

    /**
     * 生成验证码
     * @param passengerPhone 手机号
     * @return
     */
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

    /**
     * 校验验证码
     * @param passengerPhone 手机号
     * @param verificationCode 验证码
     * @return
     */
    public ResponseResult checkCode(String passengerPhone, String verificationCode){
        //根据手机号去redis读取验证码
        System.out.println("根据手机号去redis读取验证码");

        //校验验证码
        System.out.println("校验验证码");

        //判断原来是否有用户，并进行相应的处理
        System.out.println("判断原来是否有用户，并进行相应的处理");

        //颁发令牌
        System.out.println("颁发令牌");


        //相应
        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setToken("token value");
        return ResponseResult.success(tokenResponse);
    }
}