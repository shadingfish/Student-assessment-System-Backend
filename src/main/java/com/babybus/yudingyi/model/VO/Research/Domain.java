package com.babybus.yudingyi.model.VO.Research;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

@Data
@ApiModel(description = "研究记录提交请求.成果列表")
public class Domain {
    public String key;
    @ApiModelProperty(value = "产出类型", required = true,example = "我的论文")
    public String output_name;
    @ApiModelProperty(value = "类型", required = true,example = "论文")
    public String output_type;
    @ApiModelProperty(value = "出处", required = true,example = "发表所在的期刊")
    public String category;
    @ApiModelProperty(value = "级别", required = true,example = "中科院一区")
    public String ranking;
    @ApiModelProperty(value = "成果等级", required = true,example = "第一作者")
    public String level;
    @ApiModelProperty(value = "产出时间", required = true)
    public Date output_time;
    @ApiModelProperty(value = "证明材料", required = true)
    public File[] fileList;

    public Domain(String key, String output_name, String output_type, String category, String ranking, String level, Date output_time, File[] fileList) {
        this.key = key;
        this.output_name = output_name;
        this.output_type = output_type;
        this.category = category;
        this.ranking = ranking;
        this.level = level;
        this.output_time = output_time;
        this.fileList = fileList;
    }

    public Domain() {
    }
}
