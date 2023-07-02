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
}
