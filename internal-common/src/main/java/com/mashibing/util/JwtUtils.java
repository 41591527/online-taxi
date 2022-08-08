package com.mashibing.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;

import javax.xml.crypto.Data;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: tutu
 * @Date: 2022/8/8 - 08 - 08 - 21:15
 * @Description: com.mashibing.util
 * @version: 1.0
 */
public class JwtUtils {

    //sign
    private static final String SIGN = "XXPmsb@#$%";

    //生成token
    public static String generatorToken(Map<String,String> map){
        //token过期时间
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,1);
        Date date = calendar.getTime();

        JWTCreator.Builder builder = JWT.create();

        //整合map
        map.forEach(
            (k,v)->{
                builder.withClaim(k,v);
            }
        );

        //整合过期时间
        builder.withExpiresAt(date);

        //生成token
        String sign = builder.sign(Algorithm.HMAC256(SIGN));


        return sign;
    }


    //解析token

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("name","zhang san");
        map.put("age","18");
        String s = generatorToken(map);
        System.out.println("生成的token：" + s);
    }
}
