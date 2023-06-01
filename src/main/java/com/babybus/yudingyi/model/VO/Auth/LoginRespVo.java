
package com.babybus.yudingyi.model.VO.Auth;
import lombok.Data;

@Data
public class LoginRespVo {
    private String accessToken;
    private String refreshToken;
}
