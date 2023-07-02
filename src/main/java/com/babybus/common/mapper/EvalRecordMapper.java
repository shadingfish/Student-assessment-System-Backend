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
    List<EvalRecord> getEvalRecordList(String type, Integer judgeId, String acYear);
    EvalRecord getEvalRecord(@Param("stuId") Integer stuId, @Param("judgeId") Integer judgeId);
    EvalRecord getEvalByType(@Param("stuId") Integer stuId, @Param("type") String type);
    void updateEvalRecord(EvalRecord evalRecord);
}
