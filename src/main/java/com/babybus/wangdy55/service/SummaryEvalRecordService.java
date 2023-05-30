package com.babybus.wangdy55.service;

import com.babybus.wangdy55.mapper.SummaryEvalRecordMapper;
import com.babybus.wangdy55.model.SummaryEvalRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SummaryEvalRecordService {
    @Autowired
    SummaryEvalRecordMapper mapper;

    public List<SummaryEvalRecord> getSummaryEvalRecordList(Integer judgeId, String acYear) {
        return mapper.getSummaryEvalRecordList(judgeId, acYear);
    }
}
