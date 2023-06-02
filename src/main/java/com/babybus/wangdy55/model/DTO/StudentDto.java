package com.babybus.wangdy55.model.DTO;

import lombok.Data;

@Data
public class StudentDto {
    String cardId; // 学号
    String name; // 姓名
    Integer grade; // 年级
    String major; // 专业
    String class1; // 班级
}
