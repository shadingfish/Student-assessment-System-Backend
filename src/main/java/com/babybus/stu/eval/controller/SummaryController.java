package com.babybus.stu.eval.controller;

import com.babybus.stu.eval.model.common.CommonResult;
import com.babybus.stu.eval.model.material.Summary;
import com.babybus.stu.eval.service.material.SummaryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "个人学年总结接口")
@RestController
@RequestMapping("/summary")
public class SummaryController {
    @Autowired
    private SummaryService summaryService;

    @ApiOperation("插入个人学年总结接口")
    @PostMapping("/insert")
    public CommonResult<?> insertSummary(@RequestBody Summary summary) {
        try {
            // 将用户信息保存到数据库
            Integer affected = summaryService.insertSummary(summary);
            if (affected == 0) {
                return CommonResult.error(500,"插入失败");
            }
            return CommonResult.success(null, "插入成功");
        } catch (Exception e) {
            System.out.println(e.toString());
            return CommonResult.error(500,"插入失败");
        }
    }

    @ApiOperation("根据学生ID和学年获取个人学年总结接口")
    @GetMapping("/get")
    public CommonResult<?> getSummary(@RequestParam Integer stuId, @RequestParam String acYear) {
        try {
            Summary summary = summaryService.getSummary(stuId, acYear);
            if (summary != null) {
                return CommonResult.success(summary, "获取成功");
            } else {
                return CommonResult.error(200,"找不到该记录");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            return CommonResult.error(500,"获取失败");
        }

    }

    @ApiOperation("获取个人学年总结列表接口")
    @GetMapping("/get-list")
    public CommonResult<?> getSummaryList(@RequestParam Integer stuId) {
        try {
            List<Summary> summaryList = summaryService.getSummaryList(stuId);
            if (!summaryList.isEmpty()) {
                return CommonResult.success(summaryList, "获取成功");
            } else {
                return CommonResult.error(200,"获取失败");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            return CommonResult.error(500,"获取失败");
        }
    }

    @ApiOperation("更新个人学年总结接口")
    @PutMapping("/update")
    public CommonResult<?> updateSummary(@RequestBody Summary summary) {
        try {
            Integer affected = summaryService.updateSummary(summary);
            if (affected == 0) {
                return CommonResult.error(200,"更新失败");
            }
            return CommonResult.success(null, "更新成功");
        } catch (Exception e) {
            System.out.println(e.toString());
            return CommonResult.error(500,"更新失败");
        }
    }

    @ApiOperation("删除个人学年总结接口")
    @DeleteMapping("/delete")
    public CommonResult<?> deleteSummary(@RequestParam Integer stuId, @RequestParam String acYear) {
        try {
            Integer affected = summaryService.deleteSummary(stuId, acYear);
            if (affected == 0) {
                return CommonResult.error(200,"删除失败");
            }
            return CommonResult.success(null, "删除成功");
        } catch (Exception e) {
            System.out.println(e.toString());
            return CommonResult.error(500,"删除失败");
        }
    }
}
