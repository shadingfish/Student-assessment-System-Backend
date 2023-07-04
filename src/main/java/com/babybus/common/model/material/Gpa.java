package com.babybus.common.model.material;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Gpa {
    private Integer gpaId;          // GPA ID
    private Integer stuId;          // 学生ID
    private String cardId;          // 学生ID
    private String acYear;          // 学年
    private Double gpa;
    private Integer ranking;        // 排名
    private Integer base;           // 总人数
    private Integer confirmStatus;  // 确认状态
    private Date confirmTime;       // 确认时间
}
