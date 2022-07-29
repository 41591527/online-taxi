package com.mashibing.internalcommon.constant;

/**
 * @Auther: tutu
 * @Date: 2022/7/29 - 07 - 29 - 20:59
 * @Description: com.mashibing.internalcommon.constant
 * @version: 1.0
 */
public enum CommonStatusEnum {

    SUCCESS(1,"success"),
    FAIL(0,"fail")


    ;

    private int code;
    private String value;

    CommonStatusEnum(int code, String value) {
        this.code = code;
        this.value = value;
    }
}
