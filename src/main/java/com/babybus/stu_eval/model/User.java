package com.babybus.stu_eval.model;

import lombok.Data;

@Data
public class User {
    private String username;
    private String password; // 明文密码
}
