package com.babybus.wangdy55.controller;

import com.babybus.common.model.CommonResult;
import com.babybus.wangdy55.model.DTO.SummaryRecordDto;
import com.babybus.wangdy55.service.SummaryRecordService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "个人学年总结评审")
@RestController
@RequestMapping("/eval/summary")
public class SummaryEvalRecordController {
    @Autowired
    SummaryRecordService service;

    @GetMapping("/list")
    CommonResult<?> getSummaryEvalRecordList(Integer judgeId, String acYear) {
        try {
            List<SummaryRecordDto> list = service.getSummaryEvalRecordList(judgeId, acYear);
            return CommonResult.success(list, "获取成功");
        } catch (Exception e) {
            System.out.println(e.toString());
            return CommonResult.error(500,"获取失败");
        }
    }
}
