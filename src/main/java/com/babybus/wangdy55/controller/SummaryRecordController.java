package com.babybus.wangdy55.controller;

import com.babybus.common.model.CommonResult;
import com.babybus.wangdy55.model.DTO.EvalRecordDto;
import com.babybus.wangdy55.model.DTO.SummaryDto;
import com.babybus.wangdy55.model.DTO.SummaryRecordDto;
import com.babybus.wangdy55.service.SummaryRecordService;
import com.babybus.wangdy55.service.SummaryService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "个人学年总结评审")
@RestController
@RequestMapping("/eval/summary")
public class SummaryRecordController {
    @Autowired
    SummaryRecordService recordService;
    @Autowired
    SummaryService summaryService;

    // 获取个人总结评审记录列表
    @GetMapping("/list")
    CommonResult<List<SummaryRecordDto>> getSummaryRecordList(Integer judgeId, String acYear) {
        List<SummaryRecordDto> list = recordService.getSummaryRecordList(judgeId, acYear);
        return CommonResult.success(list, "获取成功");
    }

    // 根据学生 ID 获取学生个人总结
    @GetMapping("/{stuId}")
    CommonResult<SummaryDto> getSummary(@PathVariable("stuId")Integer stuId) throws Exception {
        SummaryDto summaryDto = summaryService.getSummaryDto(stuId, "2022-2023");
        return CommonResult.success(summaryDto, "获取成功");
    }

    @PutMapping
    CommonResult<String> updateSummaryRecord(@RequestBody EvalRecordDto record) {
        recordService.submitSummaryRecord(record);
        return CommonResult.success(null, "修改成功");
    }
}
