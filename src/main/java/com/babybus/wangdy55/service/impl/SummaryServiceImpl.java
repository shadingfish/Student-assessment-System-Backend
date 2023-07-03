package com.babybus.wangdy55.service.impl;

import com.babybus.common.model.user.Student;
import com.babybus.wangdy55.controller.vo.SummaryVo;
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

    // 提交个人学年总结
    public Integer summitSummary(Student student, SummaryVo summaryVo) {
        Summary foundSummary = summaryMapper.getSummaryByStuId(student.getId(), "2022-2023");

        Summary summary = new Summary();
        // 修改 Summary 对应的用户信息
        summary.setStuId(student.getId());
        // 修改 Summary 的各模块内容
        summary.setBehaveSum(summaryVo.getBehaveSum());
        summary.setHealthSum(summaryVo.getHealthSum());
        summary.setStudySum(summaryVo.getStudySum());
        summary.setPoliticSum(summaryVo.getPoliticSum());

        if (foundSummary != null) {
            summary.setId(foundSummary.getId());
            return summaryMapper.updateSummary(summary);
        }
        return summaryMapper.insertSummary(summary);
    }
    public Summary getSummaryByStuId(Integer stuId, String acYear) {
        return summaryMapper.getSummaryByStuId(stuId, acYear);
    }
    public List<Summary> getSummaryList(Integer stuId, String acYear) {
        return summaryMapper.getSummaryList(stuId, acYear);
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
