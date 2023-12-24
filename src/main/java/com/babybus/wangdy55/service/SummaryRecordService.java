package com.babybus.wangdy55.service;

import com.babybus.wangdy55.model.DTO.EvalRecordDto;
import com.babybus.wangdy55.model.DTO.SummaryRecordDto;

import java.util.List;

public interface SummaryRecordService {
    List<SummaryRecordDto> getSummaryRecordList(Integer judgeId, String acYear);
    Integer submitSummaryRecord(EvalRecordDto record);
}
