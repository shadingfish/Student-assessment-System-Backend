package com.babybus.stu.eval.controller;

import com.babybus.stu.eval.model.common.CommonResult;
import com.babybus.stu.eval.model.material.Practice;
import com.babybus.stu.eval.service.material.PracticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "社会实践记录接口")
@RestController
@RequestMapping("/practice")
public class PracticeController {
    @Autowired
    private PracticeService practiceService;

    @ApiOperation("插入社会实践记录")
    @PostMapping("/insert")
    public CommonResult<?> insertPractice(@RequestBody Practice practice) {
        try {
            // 将用户信息保存到数据库
            Integer affected = practiceService.insertPractice(practice);
            if (affected == 0) {
                return CommonResult.error(200,"插入失败");
            }
            return CommonResult.success(null, "插入成功");
        } catch (Exception e) {
            System.out.println(e.toString());
            return CommonResult.error(500,"插入失败");
        }
    }

    @ApiOperation("获取社会实践记录列表")
    @GetMapping("/get-list")
    public CommonResult<?> getPracticeList(@RequestParam Integer stuId) {
        try {
            List<Practice> practiceList = practiceService.getPracticeList(stuId);
            return CommonResult.success(practiceList, "获取成功");
        } catch (Exception e) {
            System.out.println(e.toString());
            return CommonResult.error(500,"获取失败");
        }
    }

    @ApiOperation("根据学生ID和学年获取社会实践记录")
    @GetMapping("/get")
    public CommonResult<?> getPracticeById(@RequestParam Integer matId) {
        try {
            Practice practice = practiceService.getPracticeById(matId);
            if (practice != null) {
                return CommonResult.success(practice, "获取成功");
            } else {
                return CommonResult.error(200,"找不到该记录");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            return CommonResult.error(500,"获取失败");
        }

    }

    @ApiOperation("更新社会实践记录")
    @PutMapping("/update")
    public CommonResult<?> updatePractice(@RequestBody Practice practice) {
        try {
            Integer affected = practiceService.updatePractice(practice);
            if (affected == 0) {
                return CommonResult.error(200,"更新失败");
            }
            return CommonResult.success(null, "更新成功");
        } catch (Exception e) {
            System.out.println(e.toString());
            return CommonResult.error(500,"更新失败");
        }
    }

    @ApiOperation("删除社会实践记录")
    @DeleteMapping("/delete")
    public CommonResult<?> deletePracticeById(@RequestParam Integer matId) {
        try {
            Integer affected = practiceService.deletePracticeById(matId);
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
