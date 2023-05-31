package com.babybus.wangdy55.service;

import com.babybus.wangdy55.mapper.SummaryMapper;
import com.babybus.wangdy55.model.Summary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SummaryService {

    public Integer insertSummary(Summary summary);
    public List<Summary> getSummaryList(Integer id);
    public Summary getSummaryById(Integer id);
    public Integer updateSummary(Summary summary);
    public Integer deleteSummaryById(Integer id);
}
