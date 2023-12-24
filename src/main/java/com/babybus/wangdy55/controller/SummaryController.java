package com.babybus.wangdy55.controller;

import com.babybus.common.model.CommonResult;
import com.babybus.common.model.user.Student;
import com.babybus.common.service.StudentService;
import com.babybus.wangdy55.controller.vo.SummaryVo;
import com.babybus.wangdy55.model.Summary;
import com.babybus.wangdy55.service.SummaryService;
import com.babybus.yudingyi.util.JwtTokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "个人学年总结")
@RestController
@RequestMapping("/summary")
public class SummaryController {
    @Autowired
    private SummaryService summaryService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @ApiOperation("提交个人学年总结")
    @PostMapping
    public CommonResult<?> summitSummary(@RequestHeader("Authorization") String accessToken, @RequestBody SummaryVo summaryVo) {
        try {
            // 将用户信息保存到数据库
            String cardId = jwtTokenUtil.getUsernameFromToken(accessToken);
            Student student = studentService.getStudentByCardId(cardId);
            Integer affected = summaryService.summitSummary(student, summaryVo);
            if (affected == 0) {
                return CommonResult.error(501,"提交失败");
            }
            return CommonResult.success(null, "提交成功");
        } catch (Exception e) {
            System.out.println(e.toString());
            return CommonResult.error(500,"提交失败");
        }
    }

    @ApiOperation("获取个人学年总结列表接口")
    @GetMapping("/list")
    public CommonResult<?> getSummaryList(@RequestHeader("Authorization") String accessToken) {
        try {
            String cardId = jwtTokenUtil.getUsernameFromToken(accessToken);
            Student student = studentService.getStudentByCardId(cardId);
            List<Summary> summaryList = summaryService.getSummaryList(student.getId(), "2022-2023");
            return CommonResult.success(summaryList, "获取成功");
        } catch (Exception e) {
            System.out.println(e.toString());
            return CommonResult.error(500,"获取失败");
        }
    }

    @ApiOperation("根据学生ID获取个人学年总结")
    @GetMapping
    public CommonResult<?> getSummary(@RequestHeader("Authorization") String accessToken) {
        try {
            String cardId = jwtTokenUtil.getUsernameFromToken(accessToken);
            Integer stuId = studentService.getStudentByCardId(cardId).getId();
            Summary summary = summaryService.getSummaryByStuId(stuId, "2022-2023");
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

    @ApiOperation("更新个人学年总结")
    @PutMapping
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

    @ApiOperation("删除个人学年总结")
    @DeleteMapping
    public CommonResult<?> deleteSummaryById(@RequestParam Integer id) {
        try {
            Integer affected = summaryService.deleteSummaryById(id);
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
