package com.babybus.stu.eval.mapper.material;

import com.babybus.stu.eval.model.material.Competition;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CompetitionMapper {
    Integer insertCompetition(Competition competition); // 插入竞赛获奖记录
    List<Competition> getCompetitionList(Integer stuId); // 根据学生ID，获取竞赛获奖记录列表
    Competition getCompetitionById(Integer matId); // 根据学生ID和学年，获取一条竞赛获奖记录
    Integer updateCompetition(Competition competition); // 根据学生ID更新对应竞赛获奖记录
    Integer deleteCompetitionById(Integer matId); // 根据学生ID和学年，删除对应竞赛获奖记录
}
