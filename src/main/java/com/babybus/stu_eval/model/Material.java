package com.babybus.stu_eval.model;
import lombok.Data;
import io.swagger.annotations.ApiModel;

import java.sql.Timestamp;
import java.util.Date;

@Data
@ApiModel(description = "各类评审材料父类")
public class Material {
    public int mat_id; //材料ID
    public int stu_id; //学生ID
    public int judge_id; //评委ID
    public String ac_year; //学年
    public String mat_type; ///MySQL中为枚举，只能为ENUM('个人报告', '志愿服务', '学生岗位', '科研成果', '竞赛获奖', '社会实践')  从1开始顺次计算对应的枚举值，前端直接传输索引值。
    public String eval_status; //MySQL中为枚举，只能为ENUM('待审核', '已通过', '未通过')  从1开始顺次计算对应的枚举值，前端直接传输索引值。
    public String remark; //评语
    public String file_url; //MySQL中为一个url
    public java.util.Date submit_time;
    public java.util.Date eval_time;

    public Material(int mat_id, int stu_id, int judge_id, String ac_year, String mat_type, String eval_status, String remark, String file_url, Date submit_time, Date eval_time) {
        this.mat_id = mat_id;
        this.stu_id = stu_id;
        this.judge_id = judge_id;
        this.ac_year = ac_year;
        this.mat_type = mat_type;
        this.eval_status = eval_status;
        this.remark = remark;
        this.file_url = file_url;
        this.submit_time = submit_time;
        this.eval_time = eval_time;
    }

    public Material(int stu_id, String ac_year, String file_url) {
        java .util.Date date = new Date();
        java.sql.Timestamp sqlDate = new Timestamp(date.getTime());
        this.mat_id = 000000;
        this.stu_id = stu_id;
        this.judge_id = 000000;
        this.ac_year = ac_year;
        this.mat_type = "mat_type";
        this.eval_status = "eval_status";
        this.remark = "";
        this.file_url = file_url;
        this.submit_time = sqlDate;
        this.eval_time = null;
    }

    public Material(){
        java .util.Date date = new Date();
        java.sql.Timestamp sqlDate = new Timestamp(date.getTime());
        this.mat_id = 000000;
        this.stu_id = 000000;
        this.judge_id = 000000;
        this.ac_year = "2022-2023";
        this.mat_type = "mat_type";
        this.eval_status = "eval_status";
        this.remark = "";
        this.file_url = "";
        this.submit_time = sqlDate;
        this.eval_time = null;
    }


}
