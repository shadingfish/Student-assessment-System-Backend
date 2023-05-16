package com.babybus.stu_eval.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(description = "用户父类")
public class User {
    private int user_id; //用户 ID
    private int card_id; //学工号
    private int chara; //角色，MySQL中为枚举类，只能为ENUM('学生', '评委', '学工管理员') 从1开始顺次计算对应的枚举值，前端直接传输索引值。
    private String password; // 明文密码
    private int status; //用户状态，MySQL中为枚举类，只能为ENUM('正常', '冻结', '注销') 从1开始顺次计算对应的枚举值，前端直接传输索引值。
    private java.util.Date birthday; //出生日期
    private int gender; //MySQL中为枚举类，只能为ENUM('女', '男') 从1开始顺次计算对应的枚举值，前端直接传输索引值。
    private String phone; //手机号码
    private String email; //电子邮箱

    public User(int user_id, int card_id, int chara, String password, int status, Date birthday, int gender, String phone, String email) {
        this.user_id = user_id;
        this.card_id = card_id;
        this.chara = chara;
        this.password = password;
        this.status = status;
        this.birthday = birthday;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
    }
}
