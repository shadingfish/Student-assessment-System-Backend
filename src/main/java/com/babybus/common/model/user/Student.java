package com.babybus.common.model.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(description = "学生")
public class Student extends BaseUser {
    @ApiModelProperty(value = "学院", required = true, example = "软件与微电子学院")
    @NotEmpty(message = "学院不能为空")
    @Length(min = 3, max = 20, message = "所输入学院名长度不正确")
    @Pattern(regexp = "^[\\u4e00-\\u9fa5]+$", message = "学院名需为中文")
    String school; // 学院
    @ApiModelProperty(value = "学院", required = true, example = "软件与微电子学院")
    @NotEmpty(message = "学院不能为空")
    @Length(min = 3, max = 20, message = "所输入学院名长度不正确")
    @Pattern(regexp = "^[\\u4e00-\\u9fa5]+$", message = "学院名需为中文")
    int grade; // 年级
    @ApiModelProperty(value = "学院", required = true, example = "软件与微电子学院")
    @NotEmpty(message = "学院不能为空")
    @Length(min = 3, max = 20, message = "所输入学院名长度不正确")
    @Pattern(regexp = "^[\\u4e00-\\u9fa5]+$", message = "学院名需为中文")
//    Clas clas;
    String clas; // 班级/学苑
    @ApiModelProperty(value = "专业）", required = true, example = "软件工程")
    @NotEmpty(message = "专业不能为空")
    @Length(min = 2, max = 16, message = "专业名长度不正确")
    @Pattern(regexp = "^[\\u4e00-\\u9fa5]+$", message = "专业名需为中文")
//    Major maj;
    String major; // 专业

    public Student(int id, String cardId, String name, String role, int roleId, String password, String status, Date birthday, String gender, String phone, String email, String school, int grade, String clas, String major) {
        super(id, cardId, name, role, roleId, password, status, birthday, gender, phone, email);
        this.school = school;
        this.grade = grade;
        this.clas = clas;
        this.major = major;
    }

    public Student() {
    }
//    // 班级枚举类
//    enum Clas {
//        SK1("求知一苑"),
//        SK2("求知二苑"),
//        SK3("求知三苑");
//
//        private final String value;
//
//        Clas(String value) {
//            this.value = value;
//        }
//        public String getValue() {
//            return value;
//        }
//    }
//
//    // 专业枚举类
//    enum Major {
//        SE("软件工程"),
//        EI("电子信息"),
//        MEM("工程管理 (MEM)");
//
//        private final String value;
//
//        Major(String value) {
//            this.value = value;
//        }
//        public String getValue() {
//            return value;
//        }
//    }
}