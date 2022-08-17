package com.mashibing.service;

import com.mashibing.constant.AmapConfigConstants;
import com.mashibing.constant.CommonStatusEnum;
import com.mashibing.dto.DicDistrict;
import com.mashibing.dto.ResponseResult;
import com.mashibing.mapper.DicDistrictMapper;
import com.mashibing.remote.MapDicDistrictClient;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
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
    @Autowired
    private DicDistrictMapper dicDistrictMapper;

    @Value("${amap.key}")
    private String amapKey;

    public ResponseResult initDicDistrict(String keywords){

        // 请求地图
        String dicDistrictResult = mapDicDistrictClient.dicDistrict(keywords);
        // 解析结果
        JSONObject dicDistrictJsonObject = JSONObject.fromObject(dicDistrictResult);
        int status = dicDistrictJsonObject.getInt(AmapConfigConstants.STATUS);
        if (status != 1){
            return ResponseResult.fail(CommonStatusEnum.MAP_DISTRICT.getCode(),CommonStatusEnum.MAP_DISTRICT.getValue());
        }
        JSONArray countryJsonArray = dicDistrictJsonObject.getJSONArray(AmapConfigConstants.DISTRICTS);
        for (int i = 0 ; i < countryJsonArray.size() ; i++){
            JSONObject countryJsonObject = countryJsonArray.getJSONObject(i);
            String countryAddressCode = countryJsonObject.getString(AmapConfigConstants.ADCODE);
            String countryAddressName = countryJsonObject.getString(AmapConfigConstants.NAME);
            String countryAarentAddressCode = "0";
            String countryAevel = countryJsonObject.getString(AmapConfigConstants.LEVEL);

            insertDicDistrict(countryAddressCode,countryAddressName,countryAevel,countryAarentAddressCode);

            JSONArray provinceJsonArray = countryJsonObject.getJSONArray(AmapConfigConstants.DISTRICTS);
            for (int p = 0 ; p < provinceJsonArray.size() ; p ++){
                JSONObject provinceJsonObject = provinceJsonArray.getJSONObject(p);
                String provinceAddressCode = provinceJsonObject.getString(AmapConfigConstants.ADCODE);
                String provinceAddressName = provinceJsonObject.getString(AmapConfigConstants.NAME);
                String provinceParentAddressCode = countryAddressCode;
                String provinceLevel = provinceJsonObject.getString(AmapConfigConstants.LEVEL);

                insertDicDistrict(provinceAddressCode,provinceAddressName,provinceLevel,provinceParentAddressCode);

                JSONArray cityArray = provinceJsonObject.getJSONArray(AmapConfigConstants.DISTRICTS);
                for (int c = 0 ; c < cityArray.size() ; c ++){
                    JSONObject cityJsonObject = cityArray.getJSONObject(c);
                    String cityAddressCode = cityJsonObject.getString(AmapConfigConstants.ADCODE);
                    String cityAddressName = cityJsonObject.getString(AmapConfigConstants.NAME);
                    String cityParentAddressCode = provinceAddressCode;
                    String cityLevel = cityJsonObject.getString(AmapConfigConstants.LEVEL);

                    insertDicDistrict(cityAddressCode,cityAddressName,cityLevel,cityParentAddressCode);

                    JSONArray districtArray = cityJsonObject.getJSONArray(AmapConfigConstants.DISTRICTS);

                    for (int d = 0 ; d < districtArray.size() ; d ++){
                        JSONObject districtJsonObject = districtArray.getJSONObject(d);
                        String districtAddressCode = districtJsonObject.getString(AmapConfigConstants.ADCODE);
                        String districtAddressName = districtJsonObject.getString(AmapConfigConstants.NAME);
                        String districtParentAddressCode = cityAddressCode;
                        String districtLevel = districtJsonObject.getString(AmapConfigConstants.LEVEL);

                        if (districtLevel.equals(AmapConfigConstants.STREET)){
                            continue;
                        }

                        insertDicDistrict(districtAddressCode,districtAddressName,districtLevel,districtParentAddressCode);

                    }
                }
            }

        }
        // 插入数据库
        return ResponseResult.success();
    }

    public void insertDicDistrict(String addressCode,String addressName,String level,String parentAddressCode){
        DicDistrict dicDistrict = new DicDistrict();
        dicDistrict.setAddressCode(addressCode);
        dicDistrict.setAddressName(addressName);
        int levelInt = generateLevel(level);
        dicDistrict.setLevel(levelInt);
        dicDistrict.setParentAddressCode(parentAddressCode);
        dicDistrictMapper.insert(dicDistrict);
    }

    public int generateLevel (String level){
        int levelInt = 0;
        if (level.trim().equals("country")){
            levelInt = 0;
        }else if (level.trim().equals("province")){
            levelInt = 1;
        }else if (level.trim().equals("city")){
            levelInt = 2;
        }else if (level.trim().equals("district")){
            levelInt = 3;
        }
        return levelInt;
    }
}
