package com.mashibing.service;

import com.mashibing.constant.AmapConfigConstants;
import com.mashibing.dto.ResponseResult;
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

    @Value("${amap.key}")
    private String amapKey;

    public ResponseResult initDicDistrict(String keywords){
        // 拼装url
        StringBuilder url = new StringBuilder();
        url.append(AmapConfigConstants.DISTRICT_URL);
        url.append("?");
        url.append("keywords=" + keywords);
        url.append("&");
        url.append("subdistrict=3");
        url.append("&");
        url.append("key=" + amapKey );

        // 解析结果

        // 插入数据库
        return ResponseResult.success();
    }
}
