package com.babybus.stu.eval.service.material;

import com.babybus.stu.eval.mapper.material.SummaryMapper;
import com.babybus.stu.eval.model.material.Summary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SummaryService {
    @Autowired
    private SummaryMapper summaryMapper;

    public Integer insertSummary(Summary summary) {
        return summaryMapper.insertSummary(summary);
    }
    public List<Summary> getSummaryList(Integer stuId) {
        return summaryMapper.getSummaryList(stuId);
    }
    public Summary getSummaryById(Integer matId) {
        return summaryMapper.getSummaryById(matId);
    }
    public Integer updateSummary(Summary summary) {
        return summaryMapper.updateSummary(summary);
    }
    public Integer deleteSummaryById(Integer matId) {
        return summaryMapper.deleteSummaryById(matId);
    }
}
