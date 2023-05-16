package com.babybus.stu_eval.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Data
public class StuSum {
    private String perf_id;
    private String stu_id;
    @Length(min=9,max=9,message = "请输入正确的格式，例如：2022-2023")
    @Pattern(regexp = "202[0-9]-202[0-9]$", message = "请输入正确的格式，例如：2022-2023")
    private String ac_year;
    private String scholarship;
    @Pattern(regexp = "待审核|已通过|未通过", message = "请输入”待审核“、”已通过“、”未通过“其中一种")
    private String eval_status;
    @Max(100)
    @Min(0)
    private Integer gpa_score;
    @Max(100)
    @Min(0)
    private Integer report_score;
    @Max(100)
    @Min(0)
    private Integer volun_score;
    @Max(100)
    @Min(0)
    private Integer occup_score;
    @Max(100)
    @Min(0)
    private Integer research_score;
    @Max(100)
    @Min(0)
    private Integer award_score;
    @Max(100)
    @Min(0)
    private Integer practice_score;






}
