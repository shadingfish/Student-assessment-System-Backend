package com.babybus.wangdy55.controller.vo;

import lombok.Data;

import java.sql.Date;

@Data
public class VolunteerActivityVo {
    private Date activityTime;
    private String activityName;
    private String depart;
    private Float duration;
}
