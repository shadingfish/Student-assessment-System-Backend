package com.babybus.stu_eval.controller.vo.Research;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "研究记录提交请求.成果列表.证明材料")
public class File {
    @ApiModelProperty(value = "文件名", required = true, example = "lunwen.pdf")
    public String name;
    @ApiModelProperty(value = "文件地址", required = true, example = "http://localhost:8080/fill")
    public String url;
    public String status;
    public long uid;

    public File(String file_name, String url, String status, long uid) {
        this.name = file_name;
        this.url = url;
        this.status = status;
        this.uid = uid;
    }

    public File(String file_name, String url) {
        this.name = file_name;
        this.url = url;
        this.status = "success";
        this.uid = 10000;
    }

    public File() {
        this.name = "提交的文件";
        this.url = "url";
        status = "success";
        uid = 10000;
    }
}