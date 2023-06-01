package com.babybus.stu.eval.model.evaluation;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Data
public class EvalResult {
    private int perfId;
    private int stuId;
    private String cardId;
    @Length(min=9,max=9,message = "请输入正确的格式，例如：2022-2023")
    @Pattern(regexp = "202[0-9]-202[0-9]$", message = "请输入正确的格式，例如：2022-2023")
    private String acYear;
    private String scholarship;
    @Pattern(regexp = "待审核|已通过|未通过", message = "请输入”待审核“、”已通过“、”未通过“其中一种")
    private String evalStatus;
    @Max(100)
    @Min(0)
    private Integer gpaScore;
    @Max(100)
    @Min(0)
    private Integer reportScore;
    @Max(100)
    @Min(0)
    private Integer volunScore;
    @Max(100)
    @Min(0)
    private Integer occupScore;
    @Max(100)
    @Min(0)
    private Integer researchScore;
    @Max(100)
    @Min(0)
    private Integer awardScore;
    @Max(100)
    @Min(0)
    private Integer practiceScore;
}
