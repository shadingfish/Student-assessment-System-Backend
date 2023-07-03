package com.babybus.yudingyi.service;

import com.babybus.common.mapper.EvalRecordMapper;
import com.babybus.common.model.EvalRecord;
import org.springframework.stereotype.Service;

@Service
public class EvalRecordService {
    private final EvalRecordMapper evalRecordMapper;

    public EvalRecordService(EvalRecordMapper evalRecordMapper) {
        this.evalRecordMapper = evalRecordMapper;
    }

    public EvalRecord getEvalRecord(Integer stuId, Integer judgeId) {
        return evalRecordMapper.getEvalRecord(stuId, judgeId);
    }

    public EvalRecord getEvalByType(Integer stuId, String type) {
        return evalRecordMapper.getEvalByType(stuId, type);
    }

    public void updateEvalRecord(EvalRecord evalRecord) {
        evalRecordMapper.updateEvalRecord(evalRecord);
    }

    public void insertEvalRecord(EvalRecord evalRecord) {
        evalRecordMapper.insertEvalRecord(evalRecord);
    }
}
