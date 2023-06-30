package com.babybus.wangdy55.service;

import com.babybus.wangdy55.mapper.SummaryMapper;
import com.babybus.wangdy55.model.DTO.SummaryDto;
import com.babybus.wangdy55.model.Summary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SummaryService {

    Integer insertSummary(Summary summary);
    List<Summary> getSummaryList(Integer stuId, String acYear);
    Summary getSummaryById(Integer id);
    Integer updateSummary(Summary summary) throws Exception;
    Integer deleteSummaryById(Integer id);

    SummaryDto getSummaryDto(Integer stuId, String acYear) throws Exception;
}
