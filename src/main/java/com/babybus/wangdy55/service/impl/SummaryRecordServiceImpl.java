package com.babybus.wangdy55.service.impl;

import com.babybus.common.mapper.EvalResultMapper;
import com.babybus.common.model.EvalResult;
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
    SummaryRecordMapper summaryRecordMapper;
    @Autowired
    EvalResultMapper evalResultMapper;

    public List<SummaryRecordDto> getSummaryRecordList(Integer judgeId, String acYear) {
        return summaryRecordMapper.getSummaryRecordList(judgeId, acYear);
    }

    public Integer submitSummaryRecord(EvalRecordDto record) {
        // 查询综合评分结果表，是否有当前学生（cardId）、当前学年的综合评分记录
        EvalResult evalResult = evalResultMapper.getEvalResult(record.getStuId(), "2022-2023");
        // 若有，则更新该记录的个人总结评分
        if (evalResult != null) {
            evalResult.setReportScore(record.getScore());
            evalResultMapper.updateEvalResult(evalResult);
        }
        // 若没有，则创建新记录，并更新的个人总结评分
        else {
            EvalResult newEvalResult = new EvalResult();
            newEvalResult.setStuId(record.getStuId());
            newEvalResult.setAcYear("2022-2023");
            newEvalResult.setReportScore(record.getScore());
            evalResultMapper.insertEvalResult(newEvalResult);
        }
        // 更新个人总结的状态和评分
        return summaryRecordMapper.updateSummaryRecord(record);
    }
}
