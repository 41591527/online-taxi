package com.mashibing.dto;

import com.mashibing.constant.CommonStatusEnum;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Auther: tutu
 * @Date: 2022/8/2 - 08 - 02 - 19:55
 * @Description: com.mashibing.dto
 * @version: 1.0
 */
@Data
@Accessors(chain = true)
public class ResponseResult<T> {

    private int code;
    private String message;
    private T data;

    /**
     * 成功相应的方法
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResponseResult success(T data){
        return new ResponseResult().setCode(CommonStatusEnum.SUCCESS.getCode()).setMessage(CommonStatusEnum.SUCCESS.getValue()).setData(data);
    }

    /**
     * 失败：统一的失败
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResponseResult fail(T data){
        return new ResponseResult().setData(data);
    }

    /**
     * 失败：自定义失败 错误码和提示信息
     * @param code
     * @param message
     * @return
     */
    public static ResponseResult fail(int code,String message){
        return new ResponseResult().setCode(code).setMessage(message);
    }

    /**
     * 失败：自定义失败 错误码、提示信息、具体错误
     * @param code
     * @param message
     * @param data
     * @return
     */
    public static ResponseResult fail(int code,String message,String data){
        return new ResponseResult().setCode(code).setMessage(message).setData(data);
    }

}
