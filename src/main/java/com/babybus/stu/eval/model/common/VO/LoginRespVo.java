package com.babybus.stu.eval.model.common.VO;


import lombok.Data;

@Data
public class LoginRespVo {
    private String accessToken;
    private String refreshToken;
}
