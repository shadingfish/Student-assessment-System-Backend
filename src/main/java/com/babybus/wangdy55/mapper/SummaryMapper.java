package com.babybus.wangdy55.mapper;

import com.babybus.wangdy55.model.Summary;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SummaryMapper {
    Integer insertSummary(Summary summary); // 插入个人学年总结记录
    List<Summary> getSummaryList(Integer stuId); // 根据学生ID，获取个人学年总结记录列表
    Summary getSummary(Integer stuId, String acYear); // 根据学生ID和学年，获取个人学年总结记录
    Summary getSummaryById(Integer id); // 根据ID，获取一条个人学年总结记录
    Integer updateSummary(Summary summary); // 根据学生ID更新对应个人学年总结记录
    Integer deleteSummaryById(Integer id); // 根据ID，删除对应个人学年总结记录
}
