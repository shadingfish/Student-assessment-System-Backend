package com.babybus.stu.eval.mapper.material;

import com.babybus.stu.eval.model.material.ResearchAchieve;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ResearchAchieveMapper {
    Integer insertResearchAchieve(ResearchAchieve researchAchieve); // 插入科研成果记录
    List<ResearchAchieve> getResearchAchieveList(Integer stuId); // 根据学生ID，获取科研成果记录列表
    ResearchAchieve getResearchAchieveById(Integer matId); // 根据学生ID和学年，获取一条科研成果记录
    Integer updateResearchAchieve(ResearchAchieve researchAchieve); // 根据学生ID更新对应科研成果记录
    Integer deleteResearchAchieveById(Integer matId); // 根据学生ID和学年，删除对应科研成果记录
}
