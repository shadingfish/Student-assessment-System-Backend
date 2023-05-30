package com.babybus.common.model.material;

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
    private Date awardTime;
    private Integer ranking;
    private String award;
}
