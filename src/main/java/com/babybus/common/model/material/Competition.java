package com.babybus.common.model.material;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Date;

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(description = "学生竞赛状况")
public class Competition extends Material{
    private String compName;
    private String level;
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    private Date awardTime;
    private Integer ranking;
    private String award;
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
}
