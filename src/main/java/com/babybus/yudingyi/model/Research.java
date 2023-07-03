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
    public String description; //论文和专利的级别 MySQL中为枚举类，ENUM('专利', '中科院一区', '中科院二区', '中科院三区','中科院四区') 从1开始顺次计算对应的枚举值，前端直接传输索引值。
    public Date outputTime; //产出时间

    public Research(int id, int stuId, String cardId, String acYear, String matType, Date submitTime, String fileUrl, String fileName, String outputName, String outputType, String category, String description, Date outputTime) {
        super(id, stuId, cardId, acYear, matType, submitTime, fileUrl);
        this.fileName = fileName;
        this.outputName = outputName;
        this.outputType = outputType;
        this.category = category;
        this.description = description;
        this.outputTime = outputTime;
    }

    public Research(int id, String acYear, String fileUrl, String fileName, String outputName, String outputType, String category, String description, Date outputTime) {
        super(id, 0, "000000", acYear, "科研成果", new Date(), fileUrl);
        this.fileName = fileName;
        this.outputName = outputName;
        this.outputType = outputType;
        this.category = category;
        this.description = description;
        this.outputTime = outputTime;
    }

    public Research() {
    }

    @Override
    public String toString() {
        return "Research{" +
                "fileName='" + fileName + '\'' +
                ", outputName='" + outputName + '\'' +
                ", outputType='" + outputType + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", outputTime=" + outputTime +
                ", id=" + id +
                ", stuId=" + stuId +
                ", cardId='" + cardId + '\'' +
                ", acYear='" + acYear + '\'' +
                ", matType='" + matType + '\'' +
                ", submitTime=" + submitTime +
                ", fileUrl='" + fileUrl + '\'' +
                '}';
    }
}