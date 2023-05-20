package com.babybus.stu_eval.controller.vo.Research;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @ApiModelProperty(value = "UID", required = true)
    private String UID;
    @ApiModelProperty(value = "学年", required = true,example = "2023-2024")
    private String ac_year;
    @ApiModelProperty(value = "成果列表", required = true)
    private domain[] domains;

    @JsonCreator
    public ResearchReqVo(@JsonProperty("UID") String UID,
                         @JsonProperty("ac_year") String ac_year,
                         @JsonProperty("domains") domain[] domains) {
        this.UID = UID;
        this.ac_year = ac_year;
        this.domains = domains;
    }
}