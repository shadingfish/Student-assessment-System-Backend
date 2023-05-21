package com.babybus.stu.eval.mapper.material;

import com.babybus.stu.eval.model.material.VolunteerActivity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface VolunteerActivityMapper {
    Integer insertVolunteerActivity(VolunteerActivity volunteerActivity); // 插入志愿服务活动
    List<VolunteerActivity> getVolunteerActivityList(Integer stuId); // 根据学生ID，获取志愿服务活动列表
    VolunteerActivity getVolunteerActivityById(Integer matId); // 根据学生ID和学年，获取一条志愿服务活动
    Integer updateVolunteerActivity(VolunteerActivity volunteerActivity); // 根据学生ID更新对应志愿服务活动
    Integer deleteVolunteerActivityById(Integer matId); // 根据学生ID和学年，删除对应志愿服务活动
}
