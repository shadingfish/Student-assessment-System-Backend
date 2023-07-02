package com.babybus.common.mapper.material;

import com.babybus.common.model.EvalRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EvalRecordMapper {
    List<EvalRecord> getEvalRecordList(String type, Integer judgeId, String acYear);
    EvalRecord getEvalRecord(@Param("stuId") Integer stuId, @Param("judgeId") Integer judgeId);
    EvalRecord getEvalByType(@Param("stuId") Integer stuId, @Param("type") String type);
    void insertEvalRecord(EvalRecord evalRecord);
    void updateEvalRecord(EvalRecord evalRecord);
}
