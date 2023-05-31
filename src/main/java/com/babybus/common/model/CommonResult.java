package com.babybus.common.model;

import lombok.Data;

@Data
public class CommonResult<T> {
    T data;
    String message;
    Integer code;

    public CommonResult(T data) {
        this.data = data;
    }

    public CommonResult(T data, String msg, Integer code) {
        this.data = data;
        message = msg;
        this.code = code;
    }

    public static <T> CommonResult<T> error(Integer code, String msg) {
        return new CommonResult<>(null, msg, code);
    }

    public static <T> CommonResult<T> success(T data, String msg) {
        return new CommonResult<T>(data, msg, 200);
    }
}
