package com.mashibing.controller;

import com.mashibing.dto.DicDistrict;
import com.mashibing.mapper.DicDistrictMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: tutu
 * @Date: 2022/8/17 - 08 - 17 - 20:41
 * @Description: com.mashibing.controller
 * @version: 1.0
 */
@RestController
public class TestController {

    @Autowired
    DicDistrictMapper dicDistrictMapper;

    @GetMapping("/test-map")
    public String testMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("address_code","110000");
        List<DicDistrict> dicDistricts = dicDistrictMapper.selectByMap(map);
        System.out.println(dicDistricts);
        return "test-map";
    }
}
