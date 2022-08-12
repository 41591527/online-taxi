package com.mashibing.service;

import com.mashibing.dto.ResponseResult;
import com.mashibing.response.DirectionResponse;
import org.springframework.stereotype.Service;

/**
 * @Auther: tutu
 * @Date: 2022/8/12 - 08 - 12 - 21:49
 * @Description: com.mashibing.service
 * @version: 1.0
 */
@Service
public class DirectionService {

    /**
     * 根据去点经纬度和终点经纬度获取距离（米）和时长（分钟）
     * @param depLongitude
     * @param depLatitude
     * @param destLongitude
     * @param destLatitude
     * @return
     */
    public ResponseResult driving(String depLongitude,String depLatitude,String destLongitude,String destLatitude){

        DirectionResponse directionResponse = new DirectionResponse();
        directionResponse.setDistance(123);
        directionResponse.setDuration(456);
        return ResponseResult.success(directionResponse);
    }

}
