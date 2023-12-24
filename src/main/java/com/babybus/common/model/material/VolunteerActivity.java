package com.babybus.common.model.material;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Date;

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(description = "志愿服务活动")
public class VolunteerActivity extends Material{
    String matType = "志愿服务";

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date activityTime;
    private String activityName;
    private String depart;
    private Float duration;
    private boolean deleted = false;
}
