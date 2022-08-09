package com.mashibing.util;

/**
 * @Auther: tutu
 * @Date: 2022/8/9 - 08 - 09 - 21:31
 * @Description: com.mashibing.util
 * @version: 1.0
 */
public class RedisPrefixUtils {

    //乘客验证码的前缀
    public static String verificationCodePrefix = "passenger-verification-code-";

    //token存储的前缀
    public static String tokenPrefix = "token-";
    /**
     * 根据手机号生成key
     * @param passengerPhone
     * @return
     */
    public static String generatorKeyByPhone(String passengerPhone){
        return verificationCodePrefix + passengerPhone;
    }

    /**
     * 根据手机号和身份标识生成token
     * @param phone
     * @param identity
     * @return
     */
    public static String generatorTokenKey(String phone, String identity){
        return tokenPrefix + phone + "-" + identity;
    }
}
