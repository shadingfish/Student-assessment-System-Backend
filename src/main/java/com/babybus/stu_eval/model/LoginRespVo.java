package com.babybus.stu_eval.model;

import lombok.Data;

@Data
public class LoginRespVo {
    private String accessToken;
    private String refreshToken;
}
