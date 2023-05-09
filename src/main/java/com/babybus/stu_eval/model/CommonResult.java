package com.babybus.stu_eval.model;

import lombok.Data;

@Data
public class CommonResult<T> {
    T data;
    String message;
    Integer code;

    public CommonResult(T data) {
        this.data = data;
    }

    public static CommonResult<?> error(Integer code, String msg) {
        CommonResult<?> res = new CommonResult<>(null);
        res.code = code;
        res.message = msg;

        return res;
    }

    public CommonResult<T> success(T data) {
        CommonResult<T> res = new CommonResult<>(data);
        res.code = 200;
        res.message = "请求成功";

        return res;
    }
}
