package com.babybus.stu.eval.mapper.material;

import com.babybus.stu.eval.model.material.Summary;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SummaryMapper {
    Integer insertSummary(Summary summary); // 插入个人学年总结记录
    Summary getSummary(Integer stuId, String acYear); // 根据学生ID和学年，获取一条个人学年总结记录
    List<Summary> getSummaryList(Integer stuId); // 根据学生ID，获取个人学年总结记录列表
    Integer updateSummary(Summary summary); // 根据学生ID更新对应个人学年总结记录
    Integer deleteSummary(Integer stuId, String acYear); // 根据学生ID和学年，删除对应个人学年总结记录
}
