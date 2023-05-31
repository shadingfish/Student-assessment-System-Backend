package com.babybus.wangdy55.service;

import com.babybus.wangdy55.model.SummaryEvalRecord;

import java.util.List;

public interface SummaryEvalRecordService {
    public List<SummaryEvalRecord> getSummaryEvalRecordList(Integer judgeId, String acYear);
}
