package com.mashibing.controller;

import com.mashibing.dto.ResponseResult;
import com.mashibing.remote.ServicePriceClient;
import com.mashibing.request.ForecastPriceDTO;
import com.mashibing.service.ForecastPriceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: tutu
 * @Date: 2022/8/12 - 08 - 12 - 20:29
 * @Description: com.mashibing.controller
 * @version: 1.0
 */
@RestController
public class ForecastPriceController {

    @Autowired
    private ForecastPriceService forecastPriceService;

    @PostMapping("/forecast-price")
    public ResponseResult forecastPrice(@RequestBody ForecastPriceDTO forecastPriceDTO){

        String depLongitude = forecastPriceDTO.getDepLongitude();
        String depLatitude = forecastPriceDTO.getDepLatitude();
        String destLongitude = forecastPriceDTO.getDestLongitude();
        String destLatitude = forecastPriceDTO.getDestLatitude();

        return forecastPriceService.forecastPrice(depLongitude,depLatitude,destLongitude,destLatitude);
    }
}
