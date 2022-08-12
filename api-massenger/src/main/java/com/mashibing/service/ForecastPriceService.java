package com.mashibing.service;

import com.mashibing.dto.ResponseResult;
import com.mashibing.response.ForecastPriceResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Auther: tutu
 * @Date: 2022/8/12 - 08 - 12 - 20:34
 * @Description: com.mashibing.service
 * @version: 1.0
 */
@Service
@Slf4j
public class ForecastPriceService {


    public ResponseResult forecastPrice(String depLongitude,String depLatitude,String destLongitude,String destLatitude){
        log.info("出发地经度：" + depLongitude);
        log.info("出发地纬度：" + depLatitude);
        log.info("目的地经度：" + destLongitude);
        log.info("目的地经度：" + destLatitude);

        log.info("调用计价服务，计算价格");


        ForecastPriceResponse forecastPriceResponse = new ForecastPriceResponse();
        forecastPriceResponse.setPrice(12.34);
        return ResponseResult.success(forecastPriceResponse);
    }
}
