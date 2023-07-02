package com.babybus.common.mapper.material;

import com.babybus.common.model.material.Summary;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SumMapper {
    Integer insertSummary(Summary summary); // 插入个人学年总结记录
    List<Summary> getSummaryList(Integer stuId); // 根据学生ID，获取个人学年总结记录列表
    Summary getSummaryById(Integer matId); // 根据ID，获取一条个人学年总结记录
    Integer updateSummary(Summary summary); // 根据学生ID更新对应个人学年总结记录
    Integer deleteSummaryById(Integer matId); // 根据ID，删除对应个人学年总结记录
}
