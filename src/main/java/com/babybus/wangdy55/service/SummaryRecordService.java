package com.babybus.wangdy55.service;

import com.babybus.wangdy55.model.DTO.SummaryRecordDto;

import java.util.List;

public interface SummaryRecordService {
    List<SummaryRecordDto> getSummaryEvalRecordList(Integer judgeId, String acYear);
}
