package com.babybus.yudingyi.model.VO.Research;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(description = "研究记录提交请求")
public class ResearchReqVo {

//    gridData:{
//        id: 0,
//                output_name: '',
//                output_type: '',
//                category: '',
//                output_time: '',
//                description: '',
//                fileList: [
//        // name: '',
//        // file_url: '',
//        ],
//    },

    private int id;
    private String acYear;
    private String outputName;
    private String outputType;
    private String category;
    private java.util.Date outputTime;
    private String description;
    private String fileName;
    private String fileUrl;

    public ResearchReqVo(int id, String acYear, String outputName, String outputType, String category, Date outputTime, String description, String fileName, String fileUrl) {
        this.id = id;
        this.acYear = acYear;
        this.outputName = outputName;
        this.outputType = outputType;
        this.category = category;
        this.outputTime = outputTime;
        this.description = description;
        this.fileName = fileName;
        this.fileUrl = fileUrl;
    }

    public ResearchReqVo() {
    }
}