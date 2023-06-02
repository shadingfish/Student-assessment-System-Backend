package com.babybus.wuqile.model;


import com.babybus.common.model.material.Material;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.sql.Date;

@Data
@ApiModel(description = "记载学生竞赛状况")
public class StuComp extends Material {
    private String comp_name;
    private String level;
    private Date award_time;
    private Integer rank;
    private String award;
}
