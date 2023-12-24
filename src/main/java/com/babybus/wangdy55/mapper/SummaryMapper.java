package com.babybus.wangdy55.mapper;

import com.babybus.wangdy55.model.DTO.SummaryDto;
import com.babybus.wangdy55.model.Summary;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SummaryMapper {
    Integer insertSummary(Summary summary); // 插入个人学年总结记录
    List<Summary> getSummaryList(Integer stuId, String acYear); // 根据学生ID，获取个人学年总结记录列表
    Summary getSummaryByStuId(Integer stuId, String acYear); // 根据学生 ID，获取一条个人学年总结记录
    Integer updateSummary(Summary summary); // 根据学生ID更新对应个人学年总结记录
    Integer deleteSummaryById(Integer id); // 根据ID，删除对应个人学年总结记录

    SummaryDto getSummaryDtoById(Integer stuId, String acYear); // 根据ID，获取一条用于评审的个人学年总结记录
}
