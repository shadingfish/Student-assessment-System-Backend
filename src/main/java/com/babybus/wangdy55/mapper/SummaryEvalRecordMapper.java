package com.babybus.wangdy55.mapper;

import com.babybus.wangdy55.model.SummaryEvalRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SummaryEvalRecordMapper {
//    Integer insertRecord(SummaryEvalRecord record);
    List<SummaryEvalRecord> getSummaryEvalRecordList(@Param("judgeId")Integer judgeId, @Param("acYear")String acYear);
}
