package com.mashibing.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Auther: tutu
 * @Date: 2022/8/9 - 08 - 09 - 20:53
 * @Description: com.mashibing.interceptor
 * @version: 1.0
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    public JWTInterceptor jwtInterceptor(){
        return new JWTInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor())
                //拦截的路径
                .addPathPatterns("/**")
                 //不拦截的路径
                .excludePathPatterns("/noauthTest")
                .excludePathPatterns("/verification-code")
                .excludePathPatterns("/verification-code-check")
                .excludePathPatterns("/token-refresh");
    }
}
