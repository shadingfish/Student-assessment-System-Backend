package com.babybus.stu.eval.model.material;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(description = "学生骨干岗位任职情况")
public class Practice extends Material{
    private String pracType;
    @Pattern(regexp = "202[0-9]-[0|1][0-9]-[0-3][0-9]$", message = "请按照如下格式输入日期：YYYY-MM-DD")
    private Date startDate;
    @Pattern(regexp = "202[0-9]-[0|1][0-9]-[0-3][0-9]$", message = "请按照如下格式输入日期：YYYY-MM-DD")
    private Date endDate;
}
