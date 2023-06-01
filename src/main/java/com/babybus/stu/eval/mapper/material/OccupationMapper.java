package com.babybus.stu.eval.mapper.material;

import com.babybus.stu.eval.model.material.Occupation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OccupationMapper {
    Integer insertOccupation(Occupation occupation); // 插入竞赛获奖记录
    List<Occupation> getOccupationList(Integer stuId); // 根据学生ID，获取竞赛获奖记录列表
    Occupation getOccupationById(Integer matId); // 根据学生ID和学年，获取一条竞赛获奖记录
    Integer updateOccupation(Occupation occupation); // 根据学生ID更新对应竞赛获奖记录
    Integer deleteOccupationById(Integer matId); // 根据学生ID和学年，删除对应竞赛获奖记录
}
