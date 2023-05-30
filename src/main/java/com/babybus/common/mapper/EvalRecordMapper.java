package com.babybus.common.mapper;

import com.babybus.common.model.EvalRecord;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EvalRecordMapper {
    Integer insertEvalRecord(EvalRecord record);
    List<EvalRecord> getEvalRecordList(String type, Integer judgeId, String acYear);
}
