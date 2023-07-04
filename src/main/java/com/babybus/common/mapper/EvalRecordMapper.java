package com.babybus.common.mapper;

import com.babybus.common.model.EvalRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EvalRecordMapper {
    Integer insertEvalRecord(EvalRecord record);
    EvalRecord getEvalRecord(Integer stuId, Integer judgeId);
    EvalRecord getEvalRecord(Integer stuId);
    void updateEvalRecord(EvalRecord evalRecord);
    List<EvalRecord> getEvalRecord(String type, Integer judgeId, String acYear);
    EvalRecord getEvalByType(@Param("stuId") Integer stuId, @Param("type") String type);
}
