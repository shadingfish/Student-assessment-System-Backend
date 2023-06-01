package com.babybus.stu.eval.model.user;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(description = "学生")
public class Student extends BaseUser {
    String school; // 学院
    int grade; // 年级
//    Clas clas;
    String clas; // 班级/学苑
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