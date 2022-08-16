package com.mashibing.dto;

import lombok.Data;

/**
 * @Auther: tutu
 * @Date: 2022/8/16 - 08 - 16 - 20:43
 * @Description: com.mashibing.dto
 * @version: 1.0
 */
@Data
public class PriceRule {

    private String cityCode;

    private String vegicleType;

    private double startFare;

    private int startMile;

    private double unitPricePerMile;

    private double unitPricePerMinute;
}
