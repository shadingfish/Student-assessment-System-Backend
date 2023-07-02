package com.babybus.yudingyi.model;
import com.babybus.common.model.material.Material;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(description = "科研材料")
public class Research extends Material {
    public String fileName; //文件名称
    public String outputName; //成果名称
    public String outputType; //成果类型 MySQL中为枚举类，ENUM('学术论文', '专利') 从1开始顺次计算对应的枚举值，前端直接传输索引值。
    public String category; //论文：发表所在的期刊; 专利：专利类型
    public String description; //描述
    public java.sql.Date outputTime; //产出时间

    public Research(int id, int stuId, String carId, String acYear, String matType, Date submitTime, String fileUrl, String fileName, String outputName, String outputType, String category, String description, java.util.Date outputTime) {
        super(id, stuId, carId, acYear, matType, submitTime, fileUrl);
        java.sql.Date sqlDate =  new java.sql.Date(outputTime.getTime());
        this.fileName = fileName;
        this.outputName = outputName;
        this.outputType = outputType;
        this.category = category;
        this.description = description;
        this.outputTime = sqlDate;
    }

    public Research(int stuId, String carId, String acYear, String matType, String fileUrl, String fileName, String outputName, String outputType, String category, String description, java.util.Date outputTime) {
        super(stuId, carId, acYear, matType, fileUrl);
        this.fileName = fileName;
        java.sql.Date sqlDate =  new java.sql.Date(outputTime.getTime());
        this.outputName = outputName;
        this.outputType = outputType;
        this.category = category;
        this.description = description;
        this.outputTime = sqlDate;
    }

    public Research() {
    }
}