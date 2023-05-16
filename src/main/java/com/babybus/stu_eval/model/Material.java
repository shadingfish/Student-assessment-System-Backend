package com.babybus.stu_eval.model;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

@Data
@ApiModel(description = "各类评审材料父类")
public class Material {
    private int mat_id;
    private int stu_id;
    private int judge_id;
    private int ac_year;
    private int eval_status; //MySQL中为枚举，只能为ENUM('待审核', '已通过', '未通过')  从1开始顺次计算对应的枚举值，前端直接传输索引值。
    private String remark;
    private String file_url; //MySQL中为一个url
    private java.util.Date submit_time;
    private java.util.Date eval_time;

    public Material(int mat_id, int stu_id, int judge_id, int ac_year, int eval_status, String remark, String file_url, Date submit_time, Date eval_time) {
        this.mat_id = mat_id;
        this.stu_id = stu_id;
        this.judge_id = judge_id;
        this.ac_year = ac_year;
        this.eval_status = eval_status;
        this.remark = remark;
        this.file_url = file_url;
        this.submit_time = submit_time;
        this.eval_time = eval_time;
    }
}
