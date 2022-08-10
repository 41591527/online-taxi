package com.mashibing.controller;

import com.mashibing.dto.ResponseResult;
import com.mashibing.response.TokenResponse;
import com.mashibing.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: tutu
 * @Date: 2022/8/10 - 08 - 10 - 21:18
 * @Description: com.mashibing.controller
 * @version: 1.0
 */
@RestController
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @PostMapping("/token-refresh")
    public ResponseResult refreshToken(@RequestBody TokenResponse tokenResponse){

        String refreshTokenSrc = tokenResponse.getRefreshToken();
        System.out.println("原来的refreshToken：" + refreshTokenSrc);

        return tokenService.refreshToken(refreshTokenSrc);


    }
}
