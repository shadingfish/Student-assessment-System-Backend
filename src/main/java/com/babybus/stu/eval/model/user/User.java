package com.babybus.stu.eval.model.user;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@ApiModel(description = "用户")
public class User {
    public int userId; // 用户 ID
    public String cardId; // 学工号
    public String name; // 用户姓名
//    public Chara chara;
    public String chara; // 角色，MySQL中为枚举类，只能为ENUM('学生', '评委', '学工管理员') 从1开始顺次计算对应的枚举值，前端直接传输索引值。
    public String password; // 明文密码
//    public Status status;
    public String status; // 用户状态，MySQL中为枚举类，只能为ENUM('正常', '冻结', '注销') 从1开始顺次计算对应的枚举值，前端直接传输索引值。
    public Date birthday; // 出生日期
//    public Gender gender;
    public String gender; // MySQL中为枚举类，只能为ENUM('女', '男') 从1开始顺次计算对应的枚举值，前端直接传输索引值。
    public String phone; // 手机号码
    public String email; // 电子邮箱

    public User(int userId, String cardId, String chara, String password, String status, Date birthday, String gender, String phone, String email) {
        this.userId = userId;
        this.cardId = cardId;
//        this.chara = Chara.valueOf(chara);
        this.chara = chara;
        this.password = password;
//        this.status = Status.valueOf(status);
        this.status = status;
        this.birthday = birthday;
//        this.gender = Gender.values()[gender];
        this.gender = gender;
        this.phone = phone;
        this.email = email;
    }

    public User(){
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        this.userId = 0;
        this.cardId = "";
//        this.chara = Chara.STUDENT;
        this.chara = "学生";
        this.password = "";
//        this.status = Status.NORMAL;
        this.status = "正常";
        this.birthday = date;
//        this.gender = Gender.UNKNOWN;
        this.gender = "";
        this.phone = "";
        this.email = "";
    }

    // 用户角色枚举类
    enum Chara {
        STUDENT("学生"),
        JUDGE("评委"),
        ADMIN("学工管理员");

        private final String value;

        Chara(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    // 用户状态枚举类
    enum Status {
        NORMAL("正常"),
        FROZEN("冻结"),
        CLOSED("注销");

        private final String value;

        Status(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    // 性别枚举类
    enum Gender {
        MALE("男"),
        FEMALE("女"),
        UNKNOWN("未设置");

        private final String value;

        Gender(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
}
