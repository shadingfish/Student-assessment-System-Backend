package com.babybus.common.model.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "学生", description = "学生对象模型")
public class Student extends User {
    @ApiModelProperty(value = "学院", required = true, example = "软件与微电子学院")
    @NotEmpty(message = "学院不能为空")
    @Length(min = 3, max = 20, message = "所输入学院名长度不正确")
    @Pattern(regexp = "^[\\u4e00-\\u9fa5]+$", message = "学院名需为中文")
    String school; // 学院名

    @ApiModelProperty(value = "年级", required = true, example = "2022")
    @NotEmpty(message = "年级不能为空")
    @Length(min = 4, max = 4, message = "请输入4位数的年级")
    @Pattern(regexp = "^(1898|19[0-9]{2}|20[01][0-9]|202[0-4])$", message = "年级需为有效入学年份（阿拉伯数字）")
    Integer grade; // 年级


//    Clas clas;
    @ApiModelProperty(value = "班级/学苑）", required = true, example = "求知一苑")
    @NotEmpty(message = "班级/学苑不能为空")
    @Length(min = 2, max = 8, message = "班级/学苑名长度不正确")
    @Pattern(regexp = "^[\\u4e00-\\u9fa5]+$", message = "班级/学苑名需为中文")
    String clas; // 班级/学苑

    @ApiModelProperty(value = "专业）", required = true, example = "软件工程")
    @NotEmpty(message = "专业不能为空")
    @Length(min = 2, max = 16, message = "专业名长度不正确")
    @Pattern(regexp = "^[\\u4e00-\\u9fa5]+$", message = "专业名需为中文")
//    Major maj or;
    String major; // 专业

    // 班级枚举类
    enum Clas {
        SK1("求知一苑"),
        SK2("求知二苑"),
        SK3("求知三苑");

        private final String value;

        Clas(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    // 专业枚举类
    enum Major {
        SE("软件工程"),
        EI("电子信息"),
        MEM("工程管理 (MEM)");

        private final String value;

        Major(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
}