package com.babybus.common.service.material;

import com.babybus.common.mapper.material.SumMapper;
import com.babybus.common.model.material.Sum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SumService {
    @Autowired
    private SumMapper sumMapper;

    public Integer insertSummary(Sum sum) {
        return sumMapper.insertSummary(sum);
    }
    public List<Sum> getSummaryList(Integer stuId) {
        return sumMapper.getSummaryList(stuId);
    }
    public Sum getSummaryById(Integer matId) {
        return sumMapper.getSummaryById(matId);
    }
    public Integer updateSummary(Sum sum) {
        return sumMapper.updateSummary(sum);
    }
    public Integer deleteSummaryById(Integer matId) {
        return sumMapper.deleteSummaryById(matId);
    }
}
