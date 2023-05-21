package com.babybus.stu.eval.controller;

import com.babybus.stu.eval.model.common.CommonResult;
import com.babybus.stu.eval.model.common.Log;
import com.babybus.stu.eval.service.LogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "日志接口")
@RestController
@RequestMapping("/log")
public class LogController {
    @Autowired
    private LogService logService;

    @ApiOperation("插入日志")
    @PostMapping("/insert")
    public CommonResult<?> insertLog(@RequestBody Log log) {
        try {
            // 将用户信息保存到数据库
            Integer affected = logService.insertLog(log);
            if (affected == 0) {
                return CommonResult.error(200,"插入失败");
            }
            return CommonResult.success(log, "插入成功");
        } catch (Exception e) {
            System.out.println(e);
            return CommonResult.error(500,"插入失败");
        }
    }

    @ApiOperation("获取日志列表")
    @GetMapping("/get-list")
    public CommonResult<?> getLogList() {
        try {
            List<Log> logList = logService.getLogList();
            return CommonResult.success(logList, "获取成功");
        } catch (Exception e) {
            System.out.println(e);
            return CommonResult.error(500,"获取失败");
        }
    }

    @ApiOperation("根据用户ID，获取日志")
    @GetMapping("/get")
    public CommonResult<?> getLogById(@RequestParam Integer userId) {
        try {
            Log log = logService.getLogById(userId);
            if (log != null) {
                return CommonResult.success(log, "获取成功");
            } else {
                return CommonResult.error(200,"找不到该记录");
            }
        } catch (Exception e) {
            System.out.println(e);
            return CommonResult.error(500,"获取失败");
        }
    }

    @ApiOperation("更新日志")
    @PutMapping("/update")
    public CommonResult<?> updateLog(@RequestBody Log log) {
        try {
            Integer affected = logService.updateLog(log);
            if (affected == 0) {
                return CommonResult.error(200,"更新失败");
            }
            return CommonResult.success(null, "更新成功");
        } catch (Exception e) {
            System.out.println(e);
            return CommonResult.error(500,"更新失败");
        }
    }

    @ApiOperation("根据用户ID，删除日志")
    @DeleteMapping("/delete")
    public CommonResult<?> deleteLogById(@RequestParam Integer userId) {
        try {
            Integer affected = logService.deleteLogById(userId);
            if (affected == 0) {
                return CommonResult.error(200,"删除失败");
            }
            return CommonResult.success(null, "删除成功");
        } catch (Exception e) {
            System.out.println(e);
            return CommonResult.error(500,"删除失败");
        }
    }
}
