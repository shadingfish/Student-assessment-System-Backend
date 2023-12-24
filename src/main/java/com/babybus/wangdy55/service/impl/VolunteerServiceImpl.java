package com.babybus.wangdy55.service.impl;

import com.babybus.common.model.material.VolunteerActivity;
import com.babybus.wangdy55.controller.vo.VolunteerActivityVo;
import com.babybus.wangdy55.mapper.VolunteerMapper;
import com.babybus.wangdy55.service.VolunteerService;
import com.babybus.yudingyi.model.VO.Research.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VolunteerServiceImpl implements VolunteerService {
    @Autowired
    private VolunteerMapper volunteerMapper;

    public Integer addVolunteerActivity(Integer stuId, VolunteerActivityVo volunteerActivityVo) {
        VolunteerActivity volunteerActivity = new VolunteerActivity();
        volunteerActivity.setStuId(stuId);
        volunteerActivity.setAcYear("2022-2023");

        volunteerActivity.setActivityTime(volunteerActivityVo.getActivityTime());
        volunteerActivity.setActivityName(volunteerActivityVo.getActivityName());
        volunteerActivity.setDepart(volunteerActivityVo.getDepart());
        volunteerActivity.setDuration(volunteerActivityVo.getDuration());
        volunteerActivity.setFileUrl(volunteerActivityVo.getFileUrl());

        volunteerMapper.insertVolunteerActivity(volunteerActivity);
        return volunteerActivity.getId();
    }
    public List<VolunteerActivity> getVolunteerActivityList(Integer stuId, String acYear) {
        return volunteerMapper.getVolunteerActivityList(stuId, acYear);
    }
    public VolunteerActivity getVolunteerActivityById(Integer id) {
        return volunteerMapper.getVolunteerActivityById(id);
    }
    public Integer deleteVolunteerActivityById(Integer id) {
        return volunteerMapper.deleteVolunteerActivityById(id);
    }
}
