package com.babybus.wangdy55.service.impl;

import com.babybus.wangdy55.mapper.SummaryMapper;
import com.babybus.wangdy55.model.DTO.SummaryDto;
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
    public List<Summary> getSummaryList(Integer stuId, String acYear) {
        return summaryMapper.getSummaryList(stuId, acYear);
    }
    public Summary getSummaryById(Integer id) {
        return summaryMapper.getSummaryById(id);
    }
    public Integer updateSummary(Summary summary) throws Exception {
        try {
            return summaryMapper.updateSummary(summary);
        } catch (Exception e) {
            System.out.println(e.toString());
            throw new Exception("修改失败");
        }
    }
    public Integer deleteSummaryById(Integer id) {
        return summaryMapper.deleteSummaryById(id);
    }

    public SummaryDto getSummaryDto(Integer stuId, String acYear) throws Exception {
        try {
            return summaryMapper.getSummaryDtoById(stuId, acYear);
        } catch (Exception e) {
            System.out.println(e.toString());
            throw new Exception("获取失败");
        }
    }
}
