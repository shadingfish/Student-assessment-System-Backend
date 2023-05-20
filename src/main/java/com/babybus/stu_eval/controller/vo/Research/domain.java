package com.babybus.stu_eval.controller.vo.Research;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(description = "研究记录提交请求.成果列表")
public class domain {
    public String key;
    @ApiModelProperty(value = "产出类型", required = true,example = "我的论文")
    public String output_name;
    @ApiModelProperty(value = "类型", required = true,example = "论文")
    public int output_type;
    @ApiModelProperty(value = "出处", required = true,example = "发表所在的期刊")
    public String category;
    @ApiModelProperty(value = "级别", required = true,example = "中科院一区")
    public int ranking;
    @ApiModelProperty(value = "成果等级", required = true,example = "第一作者")
    public int level;
    @ApiModelProperty(value = "产出时间", required = true)
    public Date output_time;
    @ApiModelProperty(value = "证明材料", required = true)
    public file[] fileList;

    public domain(String key, String output_name, int output_type, String category, int ranking, int level, Date output_time, file[] fileList) {
        this.key = key;
        this.output_name = output_name;
        this.output_type = output_type;
        this.category = category;
        this.ranking = ranking;
        this.level = level;
        this.output_time = output_time;
        this.fileList = fileList;
    }

    public domain() {
        this.key = "key";
        this.output_name = "output_name";
        this.output_type = 1;
        this.category = "category";
        this.ranking = 1;
        this.level = 1;
        this.fileList = new file[]{new file(), new file()};
    }
}
