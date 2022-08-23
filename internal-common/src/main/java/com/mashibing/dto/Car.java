package com.mashibing.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Auther: tutu
 * @Date: 2022/8/23 - 08 - 23 - 20:08
 * @Description: com.mashibing.dto
 * @version: 1.0
 */
@Data
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String address;

    private String vehicleNo;

    /**
     * 车辆颜色（1：蓝色，2：黄色，3：黑色，4：白色，5：绿色，9：其他）
     */
    private String plateColor;

    /**
     * 核定载客位
     */
    private Integer seats;

    /**
     * 车辆厂牌
     */
    private String brand;

    /**
     * 车辆型号
     */
    private String model;

    /**
     * 车辆类型
     */
    private String vehicleType;

    /**
     * 车辆所有人
     */
    private String ownerName;

    /**
     * 车身颜色（1：白色，2：黑色）
     */
    private String vehicleColor;

    /**
     * 发动机号
     */
    private String engineId;

    private String vin;

    /**
     * 车辆注册日期
     */
    private LocalDate certifyDateA;

    /**
     * 燃料类型（1：汽油，2：柴油，3：天然气，4：液化气，5：电动，9：其他）
     */
    private String fueType;

    /**
     * 发动机排量（毫升）
     */
    private String engineDisplace;

    /**
     * 车辆运输证发证机构
     */
    private String transAgency;

    /**
     * 车辆经营区域
     */
    private String transArea;

    /**
     * 车运输证有效期起
     */
    private LocalDate transDateStart;

    /**
     * 车运输证有效期至
     */
    private LocalDate transDateEnd;

    /**
     * 车辆初次登记日期
     */
    private LocalDate centifyDateB;

    /**
     * 车辆检修状态（0：未检修，1：已检修，2：未知）
     */
    private String fixState;

    /**
     * 下次年检时间
     */
    private LocalDate nextFixDate;

    /**
     * 年度审验状态（0：未年审，1：年审合格，2：年审不合格）
     */
    private String checkState;

    /**
     * 发票打印设备序列号
     */
    private String feePrintId;

    /**
     * 卫星定位装置品牌
     */
    private String gpsBrand;

    /**
     * 卫星定位装置型号
     */
    private String gpsModel;

    /**
     * 卫星定位装置安装日期
     */
    private LocalDate gpsInstallDate;

    /**
     * 报备日期
     */
    private LocalDate registerDate;

    /**
     * 服务类型（1：网络预约出租汽车，2：巡游出租汽车，3：私人小客车合乘）
     */
    private Integer commercialType;

    /**
     * 运价编码 关联计价规则
     */
    private String fareType;

    /**
     * 车辆状态（0：有效，1：失效）
     */
    private Boolean state;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 修改时间
     */
    private LocalDateTime gmtModified;


}
