package com.babybus.common.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.lang.Nullable;

import javax.validation.constraints.Pattern;
import java.sql.Timestamp;
import java.util.Date;

@Data
@ApiModel
public class EvalRecord {
    Integer id;
    Integer stu_id;
    Integer judge_id;
    String ac_year;
    String mat_type; // 评审记录类型, ENUM('个人报告', '志愿服务', '学生岗位', '科研成果', '竞赛获奖', '社会实践')
    String eval_status; // 评审状态
    Integer score;
    Timestamp eval_time; // 评审时间
    String remark;
}
