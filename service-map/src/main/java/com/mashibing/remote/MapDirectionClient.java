package com.mashibing.remote;

import com.mashibing.constant.AmapConfigConstants;
import com.mashibing.response.DirectionResponse;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: tutu
 * @Date: 2022/8/15 - 08 - 15 - 20:10
 * @Description: com.mashibing.remote
 * @version: 1.0
 */
@Service
@Slf4j
public class MapDirectionClient {
    @Value("${amap.key}")
    private String amapKey;
    @Autowired
    private RestTemplate restTemplate;



    public DirectionResponse direction(String depLongitude, String depLatitude, String destLongitude, String destLatitude){
        //组装调用url
        // https://restapi.amap.com/v3/direction/driving
        // ?origin=116.481028,39.989643&destination=116.465302,40.004717
        // &extensions=all&output=json&key=cebe8ee6682a96143cf93e9421c6e2e4
        StringBuilder urlBuild = new StringBuilder();
        urlBuild.append(AmapConfigConstants.DIRECTION_URL);
        urlBuild.append("?");
        urlBuild.append("origin=" + depLongitude + "," + depLatitude);
        urlBuild.append("&");
        urlBuild.append("destination=" + destLongitude + "," + destLatitude);
        urlBuild.append("&");
        urlBuild.append("extensions=base");
        urlBuild.append("&");
        urlBuild.append("output=json");
        urlBuild.append("&");
        urlBuild.append("key=" + amapKey);
        log.info(urlBuild.toString());
        //调用高德接口
        ResponseEntity<String> directionEntity = restTemplate.getForEntity(urlBuild.toString(), String.class);
        String directionString = directionEntity.getBody();
        log.info("高德地图，路径规划返回信息：" + directionString);

        //解析接口
        DirectionResponse directionResponse = parseDirectionEntity(directionString);

        return directionResponse;
    }


    private DirectionResponse parseDirectionEntity(String directionString){
        DirectionResponse directionResponse = null;
        try {

            JSONObject result = JSONObject.fromObject(directionString);
            if (result.has(AmapConfigConstants.STATUS)){
                int status = result.getInt(AmapConfigConstants.STATUS);
                if (status == 1){
                    if (result.has(AmapConfigConstants.ROUTE)){
                        JSONObject routeObject = result.getJSONObject(AmapConfigConstants.ROUTE);
                        JSONArray pathArray = routeObject.getJSONArray(AmapConfigConstants.PATHS);
                        JSONObject pathObject = pathArray.getJSONObject(0);
                        directionResponse = new DirectionResponse();
                        if (pathObject.has(AmapConfigConstants.DISTANCE)){
                            int distance = pathObject.getInt(AmapConfigConstants.DISTANCE);
                            directionResponse.setDistance(distance);
                        }
                        if (pathObject.has(AmapConfigConstants.DURATION)){
                            int duration = pathObject.getInt(AmapConfigConstants.DURATION);
                            directionResponse.setDuration(duration);
                        }
                    }
                }
            }

        }catch (Exception e){

        }

        return directionResponse;
    }
}
