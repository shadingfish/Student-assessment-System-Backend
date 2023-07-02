package com.babybus.yudingyi.model.DTO;

import lombok.Data;

@Data
public class Check {
    private String ac_year;
    private int score;
    private int id;
    private String card_id;
    private String name;
    private String school;
    private int grade;
    private String major;
    private String eval_status;

    public Check(String ac_year, int score, int id, String card_id, String name, String school, int grade, String major, String eval_status) {
        this.ac_year = ac_year;
        this.score = score;
        this.id = id;
        this.card_id = card_id;
        this.name = name;
        this.school = school;
        this.grade = grade;
        this.major = major;
        this.eval_status = eval_status;
    }

    public Check() {
    }
}
