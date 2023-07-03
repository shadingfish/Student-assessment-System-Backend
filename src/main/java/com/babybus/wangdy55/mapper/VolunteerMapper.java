package com.babybus.wangdy55.mapper;

import com.babybus.common.model.material.VolunteerActivity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface VolunteerMapper {
    Integer insertVolunteerActivity(VolunteerActivity volunteerActivity);
    List<VolunteerActivity> getVolunteerActivityList(Integer stuId, String acYear);
    VolunteerActivity getVolunteerActivityById(Integer id);
    Integer deleteVolunteerActivityById(Integer id);
}
