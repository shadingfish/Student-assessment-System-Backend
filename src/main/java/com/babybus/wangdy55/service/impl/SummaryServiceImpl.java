package com.babybus.wangdy55.service.impl;

import com.babybus.wangdy55.mapper.SummaryMapper;
import com.babybus.wangdy55.model.Summary;
import com.babybus.wangdy55.service.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SummaryServiceImpl implements SummaryService {
    @Autowired
    private SummaryMapper summaryMapper;

    public Integer insertSummary(Summary summary) {
        return summaryMapper.insertSummary(summary);
    }
    public List<Summary> getSummaryList(Integer id) {
        return summaryMapper.getSummaryList(id);
    }
    public Summary getSummaryById(Integer id) {
        return summaryMapper.getSummaryById(id);
    }
    public Integer updateSummary(Summary summary) {
        return summaryMapper.updateSummary(summary);
    }
    public Integer deleteSummaryById(Integer id) {
        return summaryMapper.deleteSummaryById(id);
    }
}
