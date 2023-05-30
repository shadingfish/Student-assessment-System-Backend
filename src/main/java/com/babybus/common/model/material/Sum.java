package com.babybus.common.model.material;

import lombok.Data;
import lombok.EqualsAndHashCode;

// 个人学年总结
@Data
@EqualsAndHashCode(callSuper = true)
public class Sum extends Material {
    String politicSum; // 思想政治总结
    String behaveSum; // 行为规范总结
    String studySum; // 学习态度总结
    String healthSum; // 身心健康总结

    Sum() {
        matType = "个人报告";
    }
}
