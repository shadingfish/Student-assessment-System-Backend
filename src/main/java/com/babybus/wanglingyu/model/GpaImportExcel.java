package com.babybus.wanglingyu.model;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GpaImportExcel {
    @ExcelProperty("学号")
    private String cardId; //学号
    @ExcelProperty("学年")
    private String acYear;         //学年
    @ExcelProperty("gpa")
    private String gpa;             //gpa
    @ExcelProperty("排名")
    private String ranking;        //排名
    @ExcelProperty("总人数")
    private String base;           //总人数

}
