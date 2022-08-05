package com.mashibing.request;

import lombok.Data;

/**
 * @Auther: tutu
 * @Date: 2022/7/27 - 07 - 27 - 21:32
 * @Description: com.mashibing.apipassenger.request
 * @version: 1.0
 */
@Data
public class VerificationCodeDTO {

    private String passengerPhone;

    private String verificationCode;

}
