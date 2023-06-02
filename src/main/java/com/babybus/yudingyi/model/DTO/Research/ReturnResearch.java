package com.babybus.yudingyi.model.DTO.Research;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(description = "科研材料检索返回类型")
public class ReturnResearch {
    public int mat_id; //材料ID
    public String output_name; //成果名称
    public String output_type; //成果类型 MySQL中为枚举类，ENUM('学术论文', '专利') 从1开始顺次计算对应的枚举值，前端直接传输索引值。
    public String category; //论文：发表所在的期刊; 专利：专利类型
    public String ranking; //论文和专利的级别 MySQL中为枚举类，ENUM('专利', '中科院一区', '中科院二区', '中科院三区','中科院四区') 从1开始顺次计算对应的枚举值，前端直接传输索引值。
    public String level; //成果等级 MySQL中为枚举类，ENUM('第一作者', '第二作者', '第三作者', '第四作者') 从1开始顺次计算对应的枚举值，前端直接传输索引值。
    public java.sql.Date output_time; //产出时间
    public java.sql.Date submit_time;
    public String eval_status; //MySQL中为枚举，只能为ENUM('待审核', '已通过', '未通过')  从1开始顺次计算对应的枚举值，前端直接传输索引值。
    public String file_url; //MySQL中为一个url

    public ReturnResearch(int mat_id, String output_name, String output_type, String category, String ranking, String level, java.sql.Date output_time, java.sql.Date submit_time, String eval_status, String file_url) {
        this.mat_id = mat_id;
        this.output_name = output_name;
        this.output_type = output_type;
        this.category = category;
        this.ranking = ranking;
        this.level = level;
        this.output_time = output_time;
        this.submit_time = submit_time;
        this.eval_status = eval_status;
        this.file_url = file_url;
    }

    public ReturnResearch() {
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date date = new java.sql.Date(utilDate.getTime());
        this.mat_id = 0;
        this.eval_status = "eval_status";
        this.file_url = "无文件";
        this.submit_time = date;
        this.output_name = "output_name";
        this.output_type = "output_type";
        this.category = "category";
        this.ranking = "ranking";
        this.level = "level";
        this.output_time = date;
    }
}