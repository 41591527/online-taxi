package com.mashibing.service;

import com.mashibing.constant.CommonStatusEnum;
import com.mashibing.dto.PriceRule;
import com.mashibing.dto.ResponseResult;
import com.mashibing.mapper.PriceRuleMapper;
import com.mashibing.remote.ServiceMapClient;
import com.mashibing.request.ForecastPriceDTO;
import com.mashibing.response.DirectionResponse;
import com.mashibing.response.ForecastPriceResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: tutu
 * @Date: 2022/8/12 - 08 - 12 - 21:31
 * @Description: com.mashibing.service
 * @version: 1.0
 */
@Service
@Slf4j
public class ForecastPriceService {

    @Autowired
    private ServiceMapClient serviceMapClient;

    @Autowired
    private PriceRuleMapper priceRuleMapper;


    public ResponseResult forecastPrice(String depLongitude,String depLatitude,String destLongitude,String destLatitude){
        log.info("出发地经度：" + depLongitude);
        log.info("出发地纬度：" + depLatitude);
        log.info("目的地经度：" + destLongitude);
        log.info("目的地经度：" + destLatitude);

        log.info("调用地图服务，查询距离和时长");
        ForecastPriceDTO forecastPriceDTO = new ForecastPriceDTO();
        forecastPriceDTO.setDepLongitude(depLongitude);
        forecastPriceDTO.setDepLatitude(depLatitude);
        forecastPriceDTO.setDestLongitude(destLongitude);
        forecastPriceDTO.setDestLatitude(destLatitude);
        ResponseResult<DirectionResponse> direction = serviceMapClient.direction(forecastPriceDTO);
        Integer distance = direction.getData().getDistance();
        Integer duration = direction.getData().getDuration();
        log.info("距离：" + distance);
        log.info("时长：" + duration);

        log.info("读取计价规则");
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("city_code","110000");
        queryMap.put("vehicle_type","1");
        List<PriceRule> priceRules = priceRuleMapper.selectByMap(queryMap);
        if (priceRules.size() == 0){
            return  ResponseResult.fail(CommonStatusEnum.PRICE_RULE_EMPTY.getCode(),CommonStatusEnum.PRICE_RULE_EMPTY.getValue());
        }
        PriceRule priceRule = priceRules.get(0);

        log.info("根据距离/时长/计价规则，计算价格");


        ForecastPriceResponse forecastPriceResponse = new ForecastPriceResponse();
        forecastPriceResponse.setPrice(12.34);
        return ResponseResult.success(forecastPriceResponse);
    }
}