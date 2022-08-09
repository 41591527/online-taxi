package com.mashibing.service;

import com.mashibing.constant.CommonStatusEnum;
import com.mashibing.constant.IdentityConstant;
import com.mashibing.remote.ServicePassengerUserClient;
import com.mashibing.remote.ServiceVerificationClient;
import com.mashibing.dto.ResponseResult;
import com.mashibing.request.VerificationCodeDTO;
import com.mashibing.response.NumberCodeResponse;
import com.mashibing.response.TokenResponse;
import com.mashibing.util.JwtUtils;
import org.apache.commons.lang.StringUtils;
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

    //token存储的前缀
    private String tokenPrefix = "token-";

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

        //存入redis
        //key,value,过期时间
        String key = generatorKeyByPhone(passengerPhone);
        //存入redis
        stringRedisTemplate.opsForValue().set(key,numberCode+"",2, TimeUnit.MINUTES);

        //通过短信服务商，将对应的验证码发送到手机上。



        return ResponseResult.success("");
    }

    /**
     * 根据手机号生成key
     * @param passengerPhone
     * @return
     */
    private String generatorKeyByPhone(String passengerPhone){
        return verificationCodePrefix + passengerPhone;
    }

    /**
     * 根据手机号和身份标识生成token
     * @param phone
     * @param identity
     * @return
     */
    private String generatorTokenKey(String phone, String identity){
        return tokenPrefix + phone + "-" + identity;
    }
    /**
     * 校验验证码
     * @param passengerPhone 手机号
     * @param verificationCode 验证码
     * @return
     */

    @Autowired
    private ServicePassengerUserClient servicePassengerUserClient;

    public ResponseResult checkCode(String passengerPhone, String verificationCode){
        //根据手机号去redis读取验证码
        //生成key
        String key = generatorKeyByPhone(passengerPhone);
        //根据key获取value
        String codeRedis = stringRedisTemplate.opsForValue().get(key);
        System.out.println("redis中的value: " + codeRedis);

        //校验验证码
        if (StringUtils.isBlank(codeRedis)){
            return ResponseResult.fail(CommonStatusEnum.VERIFICATION_CODE_ERROR.getCode(),CommonStatusEnum.VERIFICATION_CODE_ERROR.getValue());
        }
        if (!verificationCode.trim().equals(codeRedis.trim())){
            return ResponseResult.fail(CommonStatusEnum.VERIFICATION_CODE_ERROR.getCode(),CommonStatusEnum.VERIFICATION_CODE_ERROR.getValue());
        }

        //判断原来是否有用户，并进行相应的处理
        VerificationCodeDTO verificationCodeDTO = new VerificationCodeDTO();
        verificationCodeDTO.setPassengerPhone(passengerPhone);
        servicePassengerUserClient.loginOrRegister(verificationCodeDTO);

        //颁发令牌
        String token = JwtUtils.generatorToken(passengerPhone, IdentityConstant.PASSENGER_IDENTITY);
        //把token存到redis中
        String tokenKey = generatorTokenKey(passengerPhone , IdentityConstant.PASSENGER_IDENTITY);
        stringRedisTemplate.opsForValue().set(tokenKey , token , 30 , TimeUnit.DAYS);

        //响应
        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setToken(token);
        return ResponseResult.success(tokenResponse);
    }
}
