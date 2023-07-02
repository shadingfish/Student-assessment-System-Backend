package com.babybus.common.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.lang.Nullable;

import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
@ApiModel
public class EvalRecord {
    Integer id;
    Integer stuId;
    String stuCardId;
    String stuName;
    Integer judgeId;
    String judgeCardId;
    String acYear;
    String matType; // 评审记录类型, ENUM('个人报告', '志愿服务', '学生岗位', '科研成果', '竞赛获奖', '社会实践')
    String evalStatus; // 评审状态
    Integer score;
    Date evalTime; // 评审时间
    String remark;

    public EvalRecord(Integer id, Integer stuId, String stuCardId, String stuName, Integer judgeId, String judgeCardId, String acYear, String matType, String evalStatus, Integer score, Date evalTime, String remark) {
        this.id = id;
        this.stuId = stuId;
        this.stuCardId = stuCardId;
        this.stuName = stuName;
        this.judgeId = judgeId;
        this.judgeCardId = judgeCardId;
        this.acYear = acYear;
        this.matType = matType;
        this.evalStatus = evalStatus;
        this.score = score;
        this.evalTime = evalTime;
        this.remark = remark;
    }

    public EvalRecord() {
    }
}
