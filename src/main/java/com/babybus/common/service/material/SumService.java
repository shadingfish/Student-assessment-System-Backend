package com.babybus.common.service.material;

import com.babybus.common.mapper.material.SumMapper;
import com.babybus.common.model.material.Summary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SumService {
    @Autowired
    private SumMapper sumMapper;

    public Integer insertSummary(Summary summary) {
        return sumMapper.insertSummary(summary);
    }
    public List<Summary> getSummaryList(Integer stuId) {
        return sumMapper.getSummaryList(stuId);
    }
    public Summary getSummaryById(Integer matId) {
        return sumMapper.getSummaryById(matId);
    }
    public Integer updateSummary(Summary summary) {
        return sumMapper.updateSummary(summary);
    }
    public Integer deleteSummaryById(Integer matId) {
        return sumMapper.deleteSummaryById(matId);
    }
}
