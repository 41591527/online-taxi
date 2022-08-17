package com.mashibing.service;

import com.mashibing.constant.AmapConfigConstants;
import com.mashibing.dto.ResponseResult;
import com.mashibing.remote.MapDicDistrictClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Auther: tutu
 * @Date: 2022/8/17 - 08 - 17 - 20:48
 * @Description: com.mashibing.service
 * @version: 1.0
 */
@Service
public class DicDistrictService {

    @Autowired
    private MapDicDistrictClient mapDicDistrictClient;

    @Value("${amap.key}")
    private String amapKey;

    public ResponseResult initDicDistrict(String keywords){

        // 请求地图
        String dicDistrict = mapDicDistrictClient.dicDistrict(keywords);
        System.out.println(dicDistrict);
        // 解析结果

        // 插入数据库
        return ResponseResult.success();
    }
}
