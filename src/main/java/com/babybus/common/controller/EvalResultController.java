package com.babybus.common.controller;

import com.babybus.common.model.CommonResult;
import com.babybus.common.model.EvalResult;
import com.babybus.common.service.EvalResultService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "学生综测成绩")
@RestController
@RequestMapping("/eval-result")
public class EvalResultController {
    @Autowired
    private EvalResultService evalResultService;

    @ApiOperation("插入学生综测成绩")
    @PostMapping("/insert")
    public CommonResult<?> insertEvalResult(@RequestBody EvalResult evalResult) {
        try {
            // 将用户信息保存到数据库
            Integer affected = evalResultService.insertEvalResult(evalResult);
            if (affected == 0) {
                return CommonResult.error(200,"插入失败");
            }
            return CommonResult.success(null, "插入成功");
        } catch (Exception e) {
            System.out.println(e.toString());
            return CommonResult.error(500,"插入失败");
        }
    }

    @ApiOperation("根据学生ID和学年，获取学生综测成绩")
    @GetMapping("/get")
    public CommonResult<?> getEvalResult(@RequestParam Integer stuId, @RequestParam String acYear) {
        try {
            EvalResult evalResult = evalResultService.getEvalResult(stuId, acYear);
            if (evalResult != null) {
                return CommonResult.success(evalResult, "获取成功");
            } else {
                return CommonResult.error(200,"找不到该记录");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            return CommonResult.error(500,"获取失败");
        }

    }

    @ApiOperation("获取学生综测成绩列表")
    @GetMapping("/get-list")
    public CommonResult<?> getEvalResultList(@RequestParam String scholarship, @RequestParam String acYear) {
        try {
            List<EvalResult> evalResultList = evalResultService.getEvalResultList(scholarship, acYear);
            if (!evalResultList.isEmpty()) {
                return CommonResult.success(evalResultList, "获取成功");
            } else {
                return CommonResult.error(200,"获取失败");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            return CommonResult.error(500,"获取失败");
        }
    }

    @ApiOperation("更新学生综测成绩")
    @PutMapping("/update")
    public CommonResult<?> updateEvalResult(@RequestBody EvalResult evalResult) {
        try {
            Integer affected = evalResultService.updateEvalResult(evalResult);
            if (affected == 0) {
                return CommonResult.error(200,"更新失败");
            }
            return CommonResult.success(null, "更新成功");
        } catch (Exception e) {
            System.out.println(e.toString());
            return CommonResult.error(500,"更新失败");
        }
    }

    @ApiOperation("删除学生综测成绩")
    @DeleteMapping("/delete")
    public CommonResult<?> deleteEvalResult(@RequestParam Integer stuId, @RequestParam String acYear) {
        try {
            Integer affected = evalResultService.deleteEvalResult(stuId, acYear);
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
