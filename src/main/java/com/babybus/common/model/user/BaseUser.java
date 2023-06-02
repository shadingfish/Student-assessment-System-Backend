package com.babybus.common.model.user;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(description = "用户")
public class BaseUser {
    private int id;// 用户 ID
    private String cardId; // 学工号
    private String name; // 用户姓名
    private String role;
    private int roleId;
    private String password; // 明文密码
    private String status; // 用户状态，MySQL中为枚举类，只能为ENUM('正常', '冻结', '注销') 从1开始顺次计算对应的枚举值，前端直接传输索引值。
    private Date birthday; // 出生日期
    private String gender; // MySQL中为枚举类，只能为ENUM('女', '男') 从1开始顺次计算对应的枚举值，前端直接传输索引值。
    private String phone; // 手机号码
    private String email; // 电子邮箱

    public BaseUser(int id, String cardId, String name, String role, int roleId, String password, String status, Date birthday, String gender, String phone, String email) {
        this.id = id;
        this.cardId = cardId;
        this.name = name;
        this.role = role;
        this.roleId = roleId;
        this.password = password;
        this.status = status;
        this.birthday = birthday;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
    }

    public BaseUser() {
    }

    //    // 用户角色枚举类
//    enum Chara {
//        STUDENT("学生"),
//        JUDGE("评委"),
//        ADMIN("学工管理员");
//
//        private final String value;
//
//        Chara(String value) {
//            this.value = value;
//        }
//        public String getValue() {
//            return value;
//        }
//    }

//    // 用户状态枚举类
//    enum Status {
//        NORMAL("正常"),
//        FROZEN("冻结"),
//        CLOSED("注销");
//
//        private final String value;
//
//        Status(String value) {
//            this.value = value;
//        }
//        public String getValue() {
//            return value;
//        }
//    }

//    // 性别枚举类
//    enum Gender {
//        MALE("男"),
//        FEMALE("女"),
//        UNKNOWN("未设置");
//
//        private final String value;
//
//        Gender(String value) {
//            this.value = value;
//        }
//        public String getValue() {
//            return value;
//        }
//    }
}
