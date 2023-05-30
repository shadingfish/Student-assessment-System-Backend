package com.babybus.common.controller.material;

import com.babybus.common.model.CommonResult;
import com.babybus.common.model.material.Sum;
import com.babybus.common.service.material.SumService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "个人学年总结")
@RestController
@RequestMapping("/sum")
public class SumController {
    @Autowired
    private SumService sumService;

    @ApiOperation("插入个人学年总结")
    @PostMapping("/insert")
    public CommonResult<?> insertSummary(@RequestBody Sum sum) {
        try {
            // 将用户信息保存到数据库
            Integer affected = sumService.insertSummary(sum);
            if (affected == 0) {
                return CommonResult.error(200,"插入失败");
            }
            return CommonResult.success(null, "插入成功");
        } catch (Exception e) {
            System.out.println(e.toString());
            return CommonResult.error(500,"插入失败");
        }
    }

    @ApiOperation("获取个人学年总结列表接口")
    @GetMapping("/get-list")
    public CommonResult<?> getSummaryList(@RequestParam Integer stuId) {
        try {
            List<Sum> sumList = sumService.getSummaryList(stuId);
            return CommonResult.success(sumList, "获取成功");
        } catch (Exception e) {
            System.out.println(e.toString());
            return CommonResult.error(500,"获取失败");
        }
    }

    @ApiOperation("根据学生ID和学年获取个人学年总结")
    @GetMapping("/get")
    public CommonResult<?> getSummary(@RequestParam Integer matId) {
        try {
            Sum sum = sumService.getSummaryById(matId);
            if (sum != null) {
                return CommonResult.success(sum, "获取成功");
            } else {
                return CommonResult.error(200,"找不到该记录");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            return CommonResult.error(500,"获取失败");
        }

    }

    @ApiOperation("更新个人学年总结")
    @PutMapping("/update")
    public CommonResult<?> updateSummary(@RequestBody Sum sum) {
        try {
            Integer affected = sumService.updateSummary(sum);
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
    @DeleteMapping("/delete")
    public CommonResult<?> deleteSummaryById(@RequestParam Integer matId) {
        try {
            Integer affected = sumService.deleteSummaryById(matId);
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
