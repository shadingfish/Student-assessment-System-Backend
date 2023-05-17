package com.babybus.stu_eval.controller.vo.Research;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.*;

//import com.babybus.stu_eval.controller.vo.res_mat;
//import org.codehaus.jackson.annotate.JsonIgnoreProperties;
//import org.codehaus.jackson.annotate.JsonProperty;

//{
//    userForm: {
//        name: '',
//        ac_year: '',
//    },
//    researchForm: {
//        domains: [
//            {
//                output_name: '',
//                output_type: '',
//                category: '',
//                ranking: '',
//                level: '',
//                output_time: '',
//                fileList: [
//                    {
//                        name: '示例（请删除）',
//                        url: '示例（请删除）'
//                    },
//                ]
//            }
//        ],
//    },
//}
@Data
@ApiModel(description = "研究记录提交请求")
public class ResearchReqVo {
    @ApiModelProperty(value = "UID", required = true,example = "2200022000")
    private String name;
    @ApiModelProperty(value = "学年", required = true,example = "2023-2024")
    private String ac_year;
    @ApiModelProperty(value = "成果列表", required = true)
    private domain[] domains;

    public ResearchReqVo(String name, String ac_year, domain[] domains) {
        this.name = name;
        this.ac_year = ac_year;
        this.domains = domains;
    }

    public ResearchReqVo() {
        this.name = "name";
        this.ac_year = "ac_year";
        this.domains = new domain[]{new domain(), new domain()};
    }
}
@Data
@ApiModel(description = "研究记录提交请求.成果列表")
class domain {
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
    public file[] fileList;

    public domain(String key, String output_name, String output_type, String category, String ranking, String level, Date output_time, file[] fileList) {
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
        this.output_type = "output_type";
        this.category = "category";
        this.ranking = "ranking";
        this.level = "level";
        this.fileList = new file[]{new file(), new file()};
    }
}

@Data
@ApiModel(description = "研究记录提交请求.成果列表.证明材料")
class file {
    @ApiModelProperty(value = "文件名", required = true,example = "lunwen.pdf")
    public String name;
    @ApiModelProperty(value = "文件地址", required = true,example = "http://localhost:8080/fill")
    public String url;

    public file(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public file() {
        this.name = "name";
        this.url = "url";
    }
}