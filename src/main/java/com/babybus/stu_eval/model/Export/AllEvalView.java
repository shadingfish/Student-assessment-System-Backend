package com.babybus.stu_eval.model.Export;

import lombok.Data;

import java.io.Serializable;

@Data
public class AllEvalView implements Serializable {
    private String card_id;
    private String name;
    private int grade;
    private String major;
    private String eval_status;
    private int gpa_score;
    private int report_score;
    private int volun_score;
    private int occup_score;
    private int research_score;
    private int award_score;
    private int practice_score;
    private double final_score;

    public AllEvalView(String card_id, String name, int grade, String major, String eval_status, int gpa_score, int report_score, int volun_score, int occup_score, int research_score, int award_score, int practice_score, double final_score) {
        this.card_id = card_id;
        this.name = name;
        this.grade = grade;
        this.major = major;
        this.eval_status = eval_status;
        this.gpa_score = gpa_score;
        this.report_score = report_score;
        this.volun_score = volun_score;
        this.occup_score = occup_score;
        this.research_score = research_score;
        this.award_score = award_score;
        this.practice_score = practice_score;
        this.final_score = final_score;
    }

    public AllEvalView() {
    }
}
