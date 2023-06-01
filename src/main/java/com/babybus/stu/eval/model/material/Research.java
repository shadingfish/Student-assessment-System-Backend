package com.babybus.stu.eval.model.material;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(description = "科研材料")
public class Research extends Material {
    public String name; //文件名称
    public String output_name; //成果名称
    public String output_type; //成果类型 MySQL中为枚举类，ENUM('学术论文', '专利') 从1开始顺次计算对应的枚举值，前端直接传输索引值。
    public String category; //论文：发表所在的期刊; 专利：专利类型
    public String ranking; //论文和专利的级别 MySQL中为枚举类，ENUM('专利', '中科院一区', '中科院二区', '中科院三区','中科院四区') 从1开始顺次计算对应的枚举值，前端直接传输索引值。
    public String level; //成果等级 MySQL中为枚举类，ENUM('第一作者', '第二作者', '第三作者', '第四作者') 从1开始顺次计算对应的枚举值，前端直接传输索引值。
    public java.util.Date output_time; //产出时间

    public Research(int mat_id, int stu_id, int judge_id, String ac_year, String mat_type,
                    String eval_status, String remark, String file_name, String file_url,
                    Date submit_time, Date eval_time, String output_name, String output_type,
                    String category, String ranking, String level, Date output_time) {
        super(mat_id, stu_id, judge_id, ac_year, mat_type, eval_status, remark, file_url, submit_time, eval_time);
        this.name = file_name;
        this.output_name = output_name;
        this.output_type = output_type;
        this.category = category;
        this.ranking = ranking;
        this.level = level;
        this.output_time = output_time;
    }

    public Research(int stu_id, String ac_year, String file_name, String file_url, String output_name, String output_type, String category, String ranking, String level, Date output_time) {
        super(stu_id, ac_year, file_url);
        this.name = file_name;
        this.output_name = output_name;
        this.output_type = output_type;
        this.category = category;
        this.ranking = ranking;
        this.level = level;
        this.output_time = output_time;
    }

    public Research() {
        super();
        Date date = new Date(System.currentTimeMillis());
        this.name = "file_name";
        this.output_name = "output_name";
        this.output_type = "output_type";
        this.category = "category";
        this.ranking = "ranking";
        this.level = "level";
        this.output_time = date;
    }
}