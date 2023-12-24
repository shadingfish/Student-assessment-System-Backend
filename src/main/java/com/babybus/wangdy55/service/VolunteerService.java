package com.babybus.wangdy55.service;

import com.babybus.common.model.material.VolunteerActivity;
import com.babybus.wangdy55.controller.vo.VolunteerActivityVo;

import java.io.File;
import java.util.List;

public interface VolunteerService {
    Integer addVolunteerActivity(Integer stuId, VolunteerActivityVo volunteerActivityVo);
//    Integer addVolunteerFile(Integer volunteerActivityId, File file);
    List<VolunteerActivity> getVolunteerActivityList(Integer stuId, String acYear);
    VolunteerActivity getVolunteerActivityById(Integer id);
    Integer deleteVolunteerActivityById(Integer id);
}
