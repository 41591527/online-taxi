package com.mashibing.service;

import com.mashibing.constant.CommonStatusEnum;
import com.mashibing.constant.DriverCarConstants;
import com.mashibing.dto.DriverCarBindingRelations;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mashibing.dto.ResponseResult;
import com.mashibing.mapper.DriverCarBindingRelationsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 咻咻咻
 * @since 2022-08-23
 */
@Service
public class DriverCarBindingRelationsService{
    @Autowired
    private DriverCarBindingRelationsMapper driverCarBindingRelationsMapper;

    public ResponseResult bind(DriverCarBindingRelations driverCarBindingRelations){
        LocalDateTime now = LocalDateTime.now();
        driverCarBindingRelations.setBindingTime(now);
        driverCarBindingRelations.setBindState(DriverCarConstants.DRIVER_CAR_BIND);
        driverCarBindingRelationsMapper.insert(driverCarBindingRelations);
        return ResponseResult.success("");
    }

    public ResponseResult unbind(DriverCarBindingRelations driverCarBindingRelations){
        LocalDateTime now = LocalDateTime.now();
        Map<String,Object> map = new HashMap<>();
        map.put("driver_id",driverCarBindingRelations.getDriverId());
        map.put("car_id",driverCarBindingRelations.getCarId());
        map.put("bind_state",DriverCarConstants.DRIVER_CAR_BIND);

        List<DriverCarBindingRelations> driverCarBindingRelations1 = driverCarBindingRelationsMapper.selectByMap(map);
        if (driverCarBindingRelations1.isEmpty()){
            return ResponseResult.fail(CommonStatusEnum.DRIVER_CAR_BIND_NOT_EXISTS.getCode(),CommonStatusEnum.DRIVER_CAR_BIND_NOT_EXISTS.getValue());
        }
        DriverCarBindingRelations relations = driverCarBindingRelations1.get(0);
        relations.setBindState(DriverCarConstants.DRIVER_CAR_UNBIND);
        relations.setUnBindingTime(now);

        driverCarBindingRelationsMapper.updateById(relations);

        return ResponseResult.success();

    }
}
