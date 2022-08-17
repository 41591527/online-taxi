package com.mashibing.controller;

import com.mashibing.dto.ResponseResult;
import com.mashibing.service.DicDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: tutu
 * @Date: 2022/8/17 - 08 - 17 - 20:47
 * @Description: com.mashibing.controller
 * @version: 1.0
 */
@RestController
public class DicDistrictController {

    @Autowired
    private DicDistrictService dicDistrictService;

    @GetMapping("/dic-district")
    public ResponseResult initDicDistrict(String keywords){

        return dicDistrictService.initDicDistrict(keywords);
    }
}
