package com.babybus.common.model.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@EqualsAndHashCode(callSuper = true)
public class Faculty extends User {
    @ApiModelProperty(value = "部门", required = true, example = "软件与微电子学院")
    @NotEmpty(message = "部门不能为空")
    @Length(min = 3, max = 20, message = "所输入部门名长度不正确")
    @Pattern(regexp = "^[\\u4e00-\\u9fa5]+$", message = "部门名需为中文")
    String depart; // 部门
    String job; // 职位
}
