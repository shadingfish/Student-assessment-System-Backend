package com.babybus.common.service.material;

import com.babybus.common.mapper.material.VolunteerActivityMapper;
import com.babybus.common.model.material.VolunteerActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerActivityService {
    @Autowired
    private VolunteerActivityMapper volunteerActivityMapper;

    public Integer insertVolunteerActivity(VolunteerActivity volunteer) {
        return volunteerActivityMapper.insertVolunteerActivity(volunteer);
    }
    public List<VolunteerActivity> getVolunteerActivityList(Integer stuId) {
        return volunteerActivityMapper.getVolunteerActivityList(stuId);
    }
    public VolunteerActivity getVolunteerActivityById(Integer matId) {
        return volunteerActivityMapper.getVolunteerActivityById(matId);
    }
    public Integer updateVolunteerActivity(VolunteerActivity volunteer) {
        return volunteerActivityMapper.updateVolunteerActivity(volunteer);
    }
    public Integer deleteVolunteerActivityById(Integer matId) {
        return volunteerActivityMapper.deleteVolunteerActivityById(matId);
    }
}
