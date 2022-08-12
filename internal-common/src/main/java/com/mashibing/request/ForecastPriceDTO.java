package com.mashibing.request;

import lombok.Data;

/**
 * @Auther: tutu
 * @Date: 2022/8/12 - 08 - 12 - 20:31
 * @Description: com.mashibing.request
 * @version: 1.0
 */
@Data
public class ForecastPriceDTO {

    private String depLongitude;

    private String depLatitude;

    private String destLongitude;

    private String destLatitude;


}
