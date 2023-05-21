package com.babybus.stu.eval.model.material;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import java.util.Date;

@Data
@ApiModel(description = "各类评审材料父类")
public class Material {
    public int matId; // 材料ID
    public int stuId; // 学生ID
    public int judgeId; // 评委ID
    public String acYear; // 学年
    public String matType; /// MySQL中为枚举，只能为ENUM('个人报告', '志愿服务', '学生岗位', '科研成果', '竞赛获奖', '社会实践')  从1开始顺次计算对应的枚举值，前端直接传输索引值。
    public String evalStatus; // MySQL中为枚举，只能为ENUM('待审核', '已通过', '未通过')  从1开始顺次计算对应的枚举值，前端直接传输索引值。
    public String remark;
    public String fileUrl; // MySQL中为一个url
    public Date submitTime;
    public Date evalTime;
}
