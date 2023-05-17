package com.babybus.stu_eval.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@ApiModel(description = "用户父类")
public class User {
    public int user_id; //用户 ID
    public String card_id; //学工号
    public int chara; //角色，MySQL中为枚举类，只能为ENUM('学生', '评委', '学工管理员') 从1开始顺次计算对应的枚举值，前端直接传输索引值。
    public String password; // 明文密码
    public int status; //用户状态，MySQL中为枚举类，只能为ENUM('正常', '冻结', '注销') 从1开始顺次计算对应的枚举值，前端直接传输索引值。
    public java.util.Date birthday; //出生日期
    public int gender; //MySQL中为枚举类，只能为ENUM('女', '男') 从1开始顺次计算对应的枚举值，前端直接传输索引值。
    public String phone; //手机号码
    public String email; //电子邮箱

    public User(int user_id, String card_id, int chara, String password, int status, Date birthday, int gender, String phone, String email) {
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

    public User(){
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        this.user_id = 000000;
        this.card_id = "000000";
        this.chara = 1;
        this.password = "000000";
        this.status = 1;
        this.birthday = date;
        this.gender = 1;
        this.phone = "000000";
        this.email = "000000";
    }
}
