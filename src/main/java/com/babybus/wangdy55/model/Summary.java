package com.babybus.wangdy55.model;


import com.babybus.common.model.material.Material;
import lombok.Data;
import lombok.EqualsAndHashCode;

// 个人学年总结
@Data
@EqualsAndHashCode(callSuper = true)
public class Summary extends Material {
    String matType = "个人报告";

    String politicSum; // 思想政治总结
    String behaveSum; // 行为规范总结
    String studySum; // 学习态度总结
    String healthSum; // 身心健康总结
}
