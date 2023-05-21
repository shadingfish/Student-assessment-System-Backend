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
    public Summary getSummary(Integer stuId, String acYear) {
        return summaryMapper.getSummary(stuId, acYear);
    }
    public List<Summary> getSummaryList(Integer stuId) {
        return summaryMapper.getSummaryList(stuId);
    }
    public Integer updateSummary(Summary summary) {
        return summaryMapper.updateSummary(summary);
    }
    public Integer deleteSummary(Integer stuId, String acYear) {
        return summaryMapper.deleteSummary(stuId, acYear);
    }
}
