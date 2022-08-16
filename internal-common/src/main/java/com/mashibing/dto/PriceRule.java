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

    private String vehicleType;

    private Double startFare;

    private Integer startMile;

    private Double unitPricePerMile;

    private Double unitPricePerMinute;
}
