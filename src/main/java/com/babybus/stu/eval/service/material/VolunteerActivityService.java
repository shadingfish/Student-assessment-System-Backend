package com.babybus.stu.eval.service.material;

import com.babybus.stu.eval.mapper.material.VolunteerActivityMapper;
import com.babybus.stu.eval.model.material.VolunteerActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerActivityService {
    @Autowired
    private VolunteerActivityMapper volunteerActivityMapper;

    public Integer insertVolunteerActivity(VolunteerActivity volunteerActivity) {
        return volunteerActivityMapper.insertVolunteerActivity(volunteerActivity);
    }
    public List<VolunteerActivity> getVolunteerActivityList(Integer stuId) {
        return volunteerActivityMapper.getVolunteerActivityList(stuId);
    }
    public VolunteerActivity getVolunteerActivityById(Integer matId) {
        return volunteerActivityMapper.getVolunteerActivityById(matId);
    }
    public Integer updateVolunteerActivity(VolunteerActivity volunteerActivity) {
        return volunteerActivityMapper.updateVolunteerActivity(volunteerActivity);
    }
    public Integer deleteVolunteerActivityById(Integer matId) {
        return volunteerActivityMapper.deleteVolunteerActivityById(matId);
    }
}
