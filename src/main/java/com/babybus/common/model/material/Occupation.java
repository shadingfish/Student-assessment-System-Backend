package com.babybus.common.model.material;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Pattern;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(description = "学生骨干岗位任职情况")
public class Occupation extends Material{
    private String depart;
    private String level;
    private String occupation;
    @Pattern(regexp = "202[0-9]-[0|1][0-9]-[0-3][0-9]$", message = "请按照如下格式输入日期：YYYY-MM-DD")
    private Date startDate;
    @Pattern(regexp = "202[0-9]-[0|1][0-9]-[0-3][0-9]$", message = "请按照如下格式输入日期：YYYY-MM-DD")
    private Date endDate;
    public int matId; //材料ID
    public int stuId; //学生ID
    public String cardId; //校园卡ID
    public int judgeId; //评委ID
    public String acYear; //学年
    public String matType; ///MySQL中为枚举，只能为ENUM('个人报告', '志愿服务', '学生岗位', '科研成果', '竞赛获奖', '社会实践')  从1开始顺次计算对应的枚举值，前端直接传输索引值。
    public String evalStatus; //MySQL中为枚举，只能为ENUM('待审核', '已通过', '未通过')  从1开始顺次计算对应的枚举值，前端直接传输索引值。
    public String remark; //评语
    public String fileUrl; //MySQL中为一个url
    public Timestamp submitTime;
    public Timestamp evalTime;

}
