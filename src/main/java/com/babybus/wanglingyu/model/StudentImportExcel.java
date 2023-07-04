package com.babybus.wanglingyu.model;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentImportExcel {

    @ExcelProperty("学工号")
    private String cardId; //学号
    @ExcelProperty("姓名")
    private String name;    //姓名

    @ExcelProperty("出生日期")
    private String birthday; //出生日期
    @ExcelProperty("性别")
    private String gender; //性别，MySQL中为枚举类，只能为ENUM('女', '男') 从1开始顺次计算对应的枚举值，前端直接传输索引值。

    @ExcelProperty("手机号码")
    private String phone; //手机号码
    @ExcelProperty("电子邮箱")
    private String email; //电子邮箱


    @ExcelProperty("学院")
    private String school; //学院
    @ExcelProperty("年级")
    private String grade; //年级
    @ExcelProperty("班级")
    private String clas; //班级
    @ExcelProperty("专业")
    private String major; //专业


    @ExcelProperty("学年")
    private String acYear;         //学年
    @ExcelProperty("申请奖学金")
    private String scholarship;     //申请奖学金

}

