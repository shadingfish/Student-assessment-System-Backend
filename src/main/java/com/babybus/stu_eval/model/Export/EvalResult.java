package com.babybus.stu_eval.model.Export;

import lombok.Data;

import java.io.Serializable;

@Data
public class EvalResult implements Serializable {
                                    //空	默认	    注释	        额外
    private Integer perf_id;        //否	无	    综测成绩 ID	AUTO_INCREMENT
    private String stu_id;          //是	NULL	学生 ID
    private String ac_year;         //否	无	    学年
    private String scholarship;     //否	无	    申请奖学金
    private String eval_status;     //否	无	    评审状态
    private Integer gpa_score;      //是	NULL	学习成绩
    private Integer report_score;   //是	NULL	个人报告成绩
    private Integer volun_score;    //是	NULL	志愿服务成绩
    private Integer occup_score;    //是	NULL	学生岗位成绩
    private Integer research_score; //是	NULL	科研成果成绩
    private Integer award_score;    //是	NULL	竞赛获奖成绩
    private Integer practice_score; //是	NULL	社会实践成绩
    private Double final_score;     //是	NULL	最终得分

    public EvalResult(Integer perf_id, String stu_id, String ac_year, String scholarship, String eval_status, Integer gpa_score, Integer report_score, Integer volun_score, Integer occup_score, Integer research_score, Integer award_score, Integer practice_score, Double final_score) {
        this.perf_id = perf_id;
        this.stu_id = stu_id;
        this.ac_year = ac_year;
        this.scholarship = scholarship;
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

    public EvalResult() {
    }
}
