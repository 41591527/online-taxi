package com.mashibing.constant;

import lombok.Data;
import lombok.Getter;

/**
 * @Auther: tutu
 * @Date: 2022/7/29 - 07 - 29 - 20:59
 * @Description: com.mashibing.internalcommon.constant
 * @version: 1.0
 */

public enum CommonStatusEnum {
    /**
     * 验证码错误提示：1000-1099
     */
    VERIFICATION_CODE_ERROR(1099,"验证码不正确"),

    /**
     * Token类提示
     */
    TOKEN_ERROR(1199,"token错误"),

    /**
     * 用户提示：1200-1299
     */
    USER_NOT_EXISTS(1200,"当前用户不存在"),

    /**
     * 计价规则：1300-1399
     * 不存在
     */
    PRICE_RULE_EMPTY(1300,"计价规则不存在"),
    /**
     * 地图信息：1400-1499
     */
    MAP_DISTRICT(1400,"请求地图错误"),
    /**
     * 司机和车辆：1500-1599
     */
    DRIVER_CAR_BIND_NOT_EXISTS(1500,"司机和车辆绑定关系不存在"),
    /**
     * 成功
     */
    SUCCESS(1,"success"),
    /**
     * 失败
     */
    FAIL(0,"fail")


    ;

    @Getter
    private int code;
    @Getter
    private String value;

    CommonStatusEnum(int code, String value) {
        this.code = code;
        this.value = value;
    }
}
