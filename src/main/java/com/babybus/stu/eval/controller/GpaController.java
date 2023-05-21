package com.babybus.stu.eval.controller;

import com.babybus.stu.eval.model.common.CommonResult;
import com.babybus.stu.eval.model.material.Gpa;
import com.babybus.stu.eval.service.material.GpaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "GPA 接口")
@RestController
@RequestMapping("/gpa")
public class GpaController {
    @Autowired
    private GpaService gpaService;

    @ApiOperation("插入 GPA")
    @PostMapping("/insert")
    public CommonResult<?> insertGpa(@RequestBody Gpa gpa) {
        try {
            // 将用户信息保存到数据库
            Integer affected = gpaService.insertGpa(gpa);
            if (affected == 0) {
                return CommonResult.error(200,"插入失败");
            }
            return CommonResult.success(null, "插入成功");
        } catch (Exception e) {
            System.out.println(e.toString());
            return CommonResult.error(500,"插入失败");
        }
    }

    @ApiOperation("获取 GPA 列表")
    @GetMapping("/get-list")
    public CommonResult<?> getGpaList(@RequestParam Integer stuId) {
        try {
            List<Gpa> gpaList = gpaService.getGpaList(stuId);
            return CommonResult.success(gpaList, "获取成功");
        } catch (Exception e) {
            System.out.println(e.toString());
            return CommonResult.error(500,"获取失败");
        }
    }

    @ApiOperation("根据学生ID和学年获取 GPA")
    @GetMapping("/get")
    public CommonResult<?> getGpa(@RequestParam Integer gpaId) {
        try {
            Gpa gpa = gpaService.getGpaById(gpaId);
            if (gpa != null) {
                return CommonResult.success(gpa, "获取成功");
            } else {
                return CommonResult.error(200,"找不到该记录");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            return CommonResult.error(500,"获取失败");
        }

    }

    @ApiOperation("更新 GPA")
    @PutMapping("/update")
    public CommonResult<?> updateGpa(@RequestBody Gpa gpa) {
        try {
            Integer affected = gpaService.updateGpa(gpa);
            if (affected == 0) {
                return CommonResult.error(200,"更新失败");
            }
            return CommonResult.success(null, "更新成功");
        } catch (Exception e) {
            System.out.println(e.toString());
            return CommonResult.error(500,"更新失败");
        }
    }

    @ApiOperation("删除 GPA")
    @DeleteMapping("/delete")
    public CommonResult<?> deleteGpaById(@RequestParam Integer gpaId) {
        try {
            Integer affected = gpaService.deleteGpaById(gpaId);
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
