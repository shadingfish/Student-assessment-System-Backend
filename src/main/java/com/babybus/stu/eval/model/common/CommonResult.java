package com.babybus.stu.eval.model.common;

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

    public static CommonResult<?> error(Integer code, String msg) {
        return new CommonResult<>(null, msg, code);
    }

    public static <T> CommonResult<?> success(T data, String msg) {
        return new CommonResult<T>(data, msg, 200);
    }
}
