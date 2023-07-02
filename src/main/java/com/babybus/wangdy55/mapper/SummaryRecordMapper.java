package com.babybus.wangdy55.mapper;

import com.babybus.wangdy55.model.DTO.EvalRecordDto;
import com.babybus.wangdy55.model.DTO.SummaryRecordDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SummaryRecordMapper {
//    Integer insertRecord(SummaryRecordDto record);
    List<SummaryRecordDto> getSummaryRecordList(@Param("judgeId")Integer judgeId, @Param("acYear")String acYear);
    Integer updateSummaryRecord(@Param("record") EvalRecordDto record);
}
