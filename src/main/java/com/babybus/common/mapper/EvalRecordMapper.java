package com.babybus.common.mapper;

import com.babybus.common.model.EvalRecord;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EvalRecordMapper {
    Integer insertEvalRecord(EvalRecord record);
    //EvalRecord getEvalRecord(Integer stu_id, Integer)
    void updateEvalRecord(EvalRecord evalRecord);
    List<EvalRecord> getEvalRecord(String type, Integer judgeId, String acYear);
}
