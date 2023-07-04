package com.babybus.wangdy55.service.impl;

import com.babybus.common.mapper.EvalRecordMapper;
import com.babybus.common.mapper.EvalResultMapper;
import com.babybus.common.model.EvalRecord;
import com.babybus.common.model.EvalResult;
import com.babybus.wangdy55.mapper.VolunteerRecordMapper;
import com.babybus.wangdy55.model.DTO.EvalRecordDto;
import com.babybus.wangdy55.model.DTO.VolunteerRecordDto;
import com.babybus.wangdy55.service.VolunteerRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerRecordServiceImpl implements VolunteerRecordService {
    @Autowired
    private VolunteerRecordMapper volunteerRecordMapper;
    @Autowired
    private EvalResultMapper evalResultMapper;
    @Autowired
    private EvalRecordMapper evalRecordMapper;

    public List<VolunteerRecordDto> getVolunteerRecordList() {
        return volunteerRecordMapper.getVolunteerRecordList();
    }

    public Integer updateVolunteerRecord(EvalRecordDto recordDto) {
        // 查询综合评分结果表，是否有当前学生（cardId）、当前学年的志愿活动记录
        EvalResult evalResult = evalResultMapper.getEvalResult(recordDto.getStuId(), "2022-2023");
        // 若有，则更新该记录的个人总结评分
        if (evalResult != null) {
            evalResult.setReportScore(recordDto.getScore());
            evalResultMapper.updateEvalResult(evalResult);
        }
        // 若没有，则创建新记录，并更新的个人总结评分
        else {
            EvalResult newEvalResult = new EvalResult();
            newEvalResult.setStuId(recordDto.getStuId());
            newEvalResult.setAcYear("2022-2023");
            newEvalResult.setReportScore(recordDto.getScore());
            evalResultMapper.insertEvalResult(newEvalResult);
        }
        // 更新个人总结的状态和评分
        return volunteerRecordMapper.updateVolunteerRecord(recordDto);
    }

    public Integer submitVolunteerRecord(Integer stuId) {
        // 查询志愿服务评分记录表，是否有当前学生（cardId）、当前学年的志愿活动填报/评分记录
        EvalRecord evalRecord = evalRecordMapper.getEvalRecord(stuId);
        // 若没有，则添加志愿活动填报/评分记录
        if (evalRecord == null) {
            evalRecord = new EvalRecord();
            evalRecord.setStuId(stuId);
            evalRecord.setAcYear("2022-2023");
            evalRecord.setMatType("志愿服务");
            evalRecordMapper.insertEvalRecord(evalRecord);
            return evalRecord.getId();
        }
        // 否则，返回志愿活动填报/评分记录的 ID
        else {
            return evalRecord.getId();
        }
    }
}
