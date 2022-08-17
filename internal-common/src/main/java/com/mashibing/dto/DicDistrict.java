package com.mashibing.dto;

import lombok.Data;

/**
 * @Auther: tutu
 * @Date: 2022/8/17 - 08 - 17 - 20:40
 * @Description: com.mashibing.dto
 * @version: 1.0
 */
@Data
public class DicDistrict {

    private String addressCode;

    private String addressName;

    private String parentAddressCode;

    private int level;
}
