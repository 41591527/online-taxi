package com.mashibing.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Auther: tutu
 * @Date: 2022/8/5 - 08 - 05 - 21:13
 * @Description: com.mashibing.dto
 * @version: 1.0
 */

@Data
public class PassengerUser {

    private Long id;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;

    private String passengerPhone;

    private String passengerName;

    private byte passengerGender;

    private byte state;

    private String profilePhoto;
}
