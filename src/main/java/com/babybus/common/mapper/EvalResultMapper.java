package com.babybus.common.mapper;

import com.babybus.common.model.EvalResult;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EvalResultMapper {
    Integer insertEvalResult(EvalResult evalResult); // 插入学生综合成绩记录
    List<EvalResult> getEvalResultList(String scholarship, String acYear); // 根据奖学金和学年，获取学生综合记录列表
    EvalResult getEvalResult(int stuId, String acYear); // 根据学生ID和学年，获取一条学生综合成绩记录
    Integer updateEvalResult(EvalResult evalResult); // 根据学生ID更新对应学生综合成绩记录
    Integer deleteEvalResult(int stuId, String acYear); // 根据学生ID和学年，删除对应学生综合成绩记录
}
