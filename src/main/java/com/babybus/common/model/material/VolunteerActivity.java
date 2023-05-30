package com.babybus.common.model.material;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Date;

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(description = "志愿服务活动")
public class VolunteerActivity extends Material{
    private Date activityTime;
    private String activityName;
    private String depart;
    private Float duration;
}
