package com.babybus.stu.eval.model.material;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
// 科研成果类
public class ResearchAchieve extends Material {
    String outputName; // 成果名称
//    OutputType outputType;
    String outputType; // 成果类型
    String category; // 论文：期刊 或 专利：专利类型
//    Level ranking;
    String ranking; // 成果等级
    Date outputTime; // 产出时间

    ResearchAchieve() {
        matType = "科研成果";
    }

    // 成果类型枚举类
    enum OutputType {
        article("学术论文"),
        patent("专利");

        OutputType(String value) {}
    }

    // 论文和专利级别枚举类
    enum Ranking {
        patent("专利"),
        cas1("中科院一区"),
        cas2("中科院二区"),
        cas3("中科院三区"),
        cas4("中科院四区");

        Ranking(String value) {}
    }

    // 成果等级枚举类
    enum Level {
        first("第一作者"),
        second("第二作者"),
        third("第三作者"),
        fourth("第四作者");


        Level(String value) {}
    }
}
