package com.babybus.wangdy55.model.DTO;

import lombok.Data;

@Data
public class EvalRecordDto {
    Integer id; // 评审记录 ID
    Integer stuId; // 学生 ID
    String evalStatus; // 评审状态
    String evalTime; // 评审时间
    Integer score; // 分数
    String remark; // 评审备注
}
