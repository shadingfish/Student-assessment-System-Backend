package com.babybus.stu_eval.model.Research;

import lombok.Data;

@Data
public class CheckResearch {
    private String ac_year;
    private String scholarship;
    private int research_score;
    private int user_id;
    private String card_id;
    private String name;
    private String school;
    private int grade;
    private String major;

    public CheckResearch(String ac_year, String scholarship, int research_score, int user_id, String card_id, String name, String school, int grade, String major) {
        this.ac_year = ac_year;
        this.scholarship = scholarship;
        this.research_score = research_score;
        this.user_id = user_id;
        this.card_id = card_id;
        this.name = name;
        this.school = school;
        this.grade = grade;
        this.major = major;
    }

    public CheckResearch() {
    }
}
