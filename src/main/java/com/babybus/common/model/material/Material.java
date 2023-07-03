package com.babybus.common.model.material;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import java.util.Date;

@Data
@ApiModel(description = "各类评审材料父类")
public class Material {
    public int id; //材料ID
    public int stuId; //学生ID
    public int judgeId; //评委ID
    public String cardId; //学号
    public String acYear; //学年
    public String matType; ///MySQL中为枚举，只能为ENUM('个人报告', '志愿服务', '学生岗位', '科研成果', '竞赛获奖', '社会实践')  从1开始顺次计算对应的枚举值，前端直接传输索引值。
    public java.util.Date submitTime;
    public String fileUrl; //MySQL中为一个url

    public Material(int id, int stuId, String cardId, String acYear, String matType, Date submitTime, String fileUrl) {
        java.util.Date sqlDate =  new java.util.Date(submitTime.getTime());
        this.id = id;
        this.stuId = stuId;
        this.cardId = cardId;
        this.acYear = acYear;
        this.matType = matType;
        this.submitTime = sqlDate;
        this.fileUrl = fileUrl;
    }

    public Material(int stuId, String cardId, String acYear, String matType, String fileUrl) {
        java.util.Date currentDate = new Date();
        java.util.Date sqlDate =  new java.util.Date(currentDate.getTime());
        this.id = 0;
        this.stuId = stuId;
        this.cardId = cardId;
        this.acYear = acYear;
        this.matType = matType;
        this.fileUrl = fileUrl;
        this.submitTime = sqlDate;
    }

    public Material(){
    }
}
