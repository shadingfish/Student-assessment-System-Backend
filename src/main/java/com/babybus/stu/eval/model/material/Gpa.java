package com.babybus.stu.eval.model.material;

import lombok.Data;

import java.util.Date;

@Data
public class Gpa {
    private Integer gpaId;          // GPA ID
    private Integer stuId;          // 学生ID
    private String acYear;          // 学年
    private Double gpa;
    private Integer ranking;        // 排名
    private Integer base;           // 总人数
    private Integer confirmStatus;  // 确认状态
    private Date confirmTime;       // 确认时间
}
