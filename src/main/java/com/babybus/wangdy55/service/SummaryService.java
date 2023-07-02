package com.babybus.wangdy55.service;

import com.babybus.common.model.user.Student;
import com.babybus.wangdy55.controller.vo.SummaryVo;
import com.babybus.wangdy55.mapper.SummaryMapper;
import com.babybus.wangdy55.model.DTO.SummaryDto;
import com.babybus.wangdy55.model.Summary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SummaryService {

    // 提交个人学年总结
    Integer summitSummary(Student student, SummaryVo summaryVo);
    Summary getSummaryByStuId(Integer stuId, String acYear);
    List<Summary> getSummaryList(Integer stuId, String acYear);
    Integer updateSummary(Summary summary) throws Exception;
    Integer deleteSummaryById(Integer id);

    SummaryDto getSummaryDto(Integer stuId, String acYear) throws Exception;
}
