package com.babybus.common.model.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
//@ApiModel(value = "用户", description = "用户对象模型")
public class User {
    public int id; // 用户ID

    @ApiModelProperty(value = "学工号", required = true, example = "2200022000")
    @NotEmpty(message = "学工号不能为空")
    @Length(min = 10, max = 10, message = "请输入10位数的学工号")
    @Pattern(regexp = "\\d+", message = "学工号需为数字")
    public String cardId; // 学工号

    @ApiModelProperty(value = "姓名", required = true, example = "软小微")
    @NotEmpty(message = "姓名不能为空")
    @Length(min = 2, max = 16, message = "姓名长度不符合要求")
    @Pattern(regexp = "^[\\p{L}\\p{M}\\p{S}]+$", message = "姓名不能包含数字和特殊符号")
    public String name; // 用户姓名

    @ApiModelProperty(value = "角色", required = true, example = "学生")
    @NotEmpty(message = "角色名不能为空")
    @Length(min = 2, max = 5, message = "角色名长度不正确")
    @Pattern(regexp = "^(学生|评委|学工管理员)$", message = "角色名只能为“学生”、“评委”或“学工管理员”")
//    public Chara chara;
    public String chara; // 角色，MySQL中为枚举类，只能为ENUM('学生', '评委', '学工管理员') 从1开始顺次计算对应的枚举值，前端直接传输索引值。

    @ApiModelProperty(value = "密码", required = true, example = "password")
    @NotEmpty(message = "密码不能为空")
    @Length(min = 6, max = 16, message = "密码长度需为6~16位")
    public String password; // 明文密码

    @ApiModelProperty(value = "账户状态", required = true, example = "正常")
    @NotEmpty(message = "账户状态不能为空")
    @Pattern(regexp = "^(正常|冻结|注销)$", message = "角色名只能为“正常”、“冻结”或“注销”")
//    public Status status;
    public String status; // 用户状态，MySQL中为枚举类，只能为ENUM('正常', '冻结', '注销') 从1开始顺次计算对应的枚举值，前端直接传输索引值。

    @ApiModelProperty(value = "出生日期", required = true, example = "2002-05-04")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "出生日期格式为YYYY-MM-DD")
    public Date birthday; // 出生日期

    @ApiModelProperty(value = "性别", required = true, example = "女")
    @Pattern(regexp = "^(男|女)$", message = "性别只能为“男”或“女”")
//    public Gender gender;
    public String gender; // MySQL中为枚举类，只能为ENUM('女', '男') 从1开始顺次计算对应的枚举值，前端直接传输索引值。

    @ApiModelProperty(value = "手机号码", required = true, example = "13000000000")
    @NotEmpty(message = "手机号码不能为空")
    @Length(min = 11, max = 11, message = "手机号码长度不正确")
    @Pattern(regexp = "^\\d{11}$", message = "手机号码只能为数字")
    public String phone; // 手机号码

    @ApiModelProperty(value = "电子邮箱", required = true, example = "2200022000@stu.pku.edu.cn")
    @Length(max = 32, message = "电子邮箱地址长度不正确")
    @Pattern(regexp = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$", message = "电子邮箱地址格式不正确")
    public String email; // 电子邮箱

    public User(int id, String cardId, String chara, String password, String status, Date birthday, String gender, String phone, String email) {
        this.id = id;
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
        this.id = 0;
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
