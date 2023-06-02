package com.babybus.wuqile.model;

import com.babybus.common.model.material.Material;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
@ApiModel(description = "记载学生骨干服务情况")
public class StuCadre extends Material {
    private String depart;
    private String level;
    private String occupation;
    @Pattern(regexp = "202[0-9]-[0|1][0-9]-[0-3][0-9]$", message = "请按照如下格式输入日期：YYYY-MM-DD")
    private Date start_date;
    @Pattern(regexp = "202[0-9]-[0|1][0-9]-[0-3][0-9]$", message = "请按照如下格式输入日期：YYYY-MM-DD")
    private Date stop_date;
}
