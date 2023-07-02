package com.babybus.wangdy55.service.impl;

import com.babybus.wangdy55.mapper.SummaryRecordMapper;
import com.babybus.wangdy55.model.DTO.EvalRecordDto;
import com.babybus.wangdy55.model.DTO.SummaryRecordDto;
import com.babybus.wangdy55.service.SummaryRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SummaryRecordServiceImpl implements SummaryRecordService {
    @Autowired
    SummaryRecordMapper mapper;

    public List<SummaryRecordDto> getSummaryRecordList(Integer judgeId, String acYear) {
        return mapper.getSummaryRecordList(judgeId, acYear);
    }

    public Integer updateSummaryRecord(EvalRecordDto record) {
        return mapper.updateSummaryRecord(record);
    }
}
