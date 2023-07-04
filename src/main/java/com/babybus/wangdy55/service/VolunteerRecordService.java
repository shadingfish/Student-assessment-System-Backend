package com.babybus.wangdy55.service;

import com.babybus.wangdy55.model.DTO.VolunteerRecordDto;

import java.util.List;

public interface VolunteerRecordService {
    List<VolunteerRecordDto> getVolunteerRecordList();
    Integer updateVolunteerRecord(VolunteerRecordDto record);
    // 学生提交志愿活动评分记录
    Integer submitVolunteerRecord(Integer stuId);
}
