package com.babybus.stu_eval.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
@ApiModel(description = "记载学生竞赛状况")
public class StuComp extends Material{
    private String comp_name;
    @Pattern(regexp = "[院级|校级|省级|国家级|国际级]$", message = "请输入合法等级：院级、校级、省级、国家级、国际级")
    private String level;
    @Pattern(regexp = "202[0-9]-[0|1][0-9]-[0-3][0-9]$", message = "请按照如下格式输入日期：YYYY-MM-DD")
    private Date award_time;
    @Max(value = 16, message = "最大值不可超过16")
    @Min(value = 1,message = "最小值为1")
    private Integer rank;
    private String award;
}
