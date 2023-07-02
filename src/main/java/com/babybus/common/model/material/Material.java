package com.babybus.common.model.material;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
@ApiModel(description = "各类评审材料父类")
public class Material {
    public int matId; //材料ID
    public int stuId; //学生ID
    public String cardId; //校园卡ID
    public int judgeId; //评委ID
    public String acYear; //学年
    public String matType; ///MySQL中为枚举，只能为ENUM('个人报告', '志愿服务', '学生岗位', '科研成果', '竞赛获奖', '社会实践')  从1开始顺次计算对应的枚举值，前端直接传输索引值。
    public String evalStatus; //MySQL中为枚举，只能为ENUM('待审核', '已通过', '未通过')  从1开始顺次计算对应的枚举值，前端直接传输索引值。
    public String remark; //评语
    public String fileUrl; //MySQL中为一个url
    public java.util.Date submitTime;
    public java.util.Date evalTime;

    public Material(int matId, int stuId, int judgeId, String acYear, String matType, String evalStatus, String remark, String fileUrl, Date submitTime, Date evalTime) {
        this.matId = matId;
        this.stuId = stuId;
        this.judgeId = judgeId;
        this.acYear = acYear;
        this.matType = matType;
        this.evalStatus = evalStatus;
        this.remark = remark;
        this.fileUrl = fileUrl;
        this.submitTime = submitTime;
        this.evalTime = evalTime;
    }

    public Material(int stuId, String acYear, String fileUrl) {
        java .util.Date date = new Date();
        java.sql.Timestamp sqlDate = new Timestamp(date.getTime());
        this.matId = 0;
        this.stuId = stuId;
        this.judgeId = 0;
        this.acYear = acYear;
        this.matType = "mat_type";
        this.evalStatus = "eval_status";
        this.remark = "";
        this.fileUrl = fileUrl;
        this.submitTime = sqlDate;
        this.evalTime = null;
    }

    public Material(){
        java .util.Date date = new Date();
        java.sql.Timestamp sqlDate = new Timestamp(date.getTime());
        this.matId = 0;
        this.stuId = 0;
        this.judgeId = 0;
        this.acYear = "2022-2023";
        this.evalStatus = "eval_status";
        this.remark = "";
        this.fileUrl = "";
        this.submitTime = sqlDate;
        this.evalTime = null;
    }


}
