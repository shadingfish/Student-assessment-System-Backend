package com.babybus.common.service;

import com.babybus.common.mapper.EvalResultMapper;
import com.babybus.common.model.EvalResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvalResultService {
    @Autowired
    private EvalResultMapper evalResultMapper;

    public Integer insertEvalResult(EvalResult evalResult) {
        return evalResultMapper.insertEvalResult(evalResult);
    }
    public EvalResult getEvalResult(Integer stuId, String acYear) {
        return evalResultMapper.getEvalResult(stuId, acYear);
    }
    public List<EvalResult> getEvalResultList(String scholarship, String acYear) {
        return evalResultMapper.getEvalResultList(scholarship, acYear);
    }

    public Integer updateEvalResult(EvalResult evalResult) {
        EvalResult origin = getEvalResult(evalResult.getStuId(), evalResult.getAcYear());

        if (origin == null) {
            return 0;
        }

        return evalResultMapper.updateEvalResult(evalResult);
    }
    public Integer deleteEvalResult(Integer stuId, String acYear) {
        EvalResult origin = getEvalResult(stuId, acYear);

        if (origin == null) {
            return 0;
        }

        return evalResultMapper.deleteEvalResult(stuId, acYear);
    }
}
