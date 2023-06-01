package com.babybus.stu.eval.yudingyi.model.VO;

import lombok.Data;

import java.sql.Date;

@Data
public class FacultyVO {
    private String cardId;
    private String name;
    private String role;
    private String password;
    private Date birthday;
    private String gender;
    private String phone;
    private String email;
    private String depart;
    private String job;

    // Getters and Setters
}
