package com.babybus.stu_eval.model.yudingyi;

import lombok.Data;

@Data
public class CheckResearch {
    private int stu_id;
    private String ac_year;
    private String scholarship;
    private int research_score;
    private String card_id;
    private String name;
    private String school;
    private int grade;
    private String major;

    public CheckResearch(int stu_id, String ac_year, String scholarship, int research_score, String card_id, String name, String school, int grade, String major) {
        this.stu_id = stu_id;
        this.ac_year = ac_year;
        this.scholarship = scholarship;
        this.research_score = research_score;
        this.card_id = card_id;
        this.name = name;
        this.school = school;
        this.grade = grade;
        this.major = major;
    }

    public CheckResearch() {
    }
}
