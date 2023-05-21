package com.babybus.stu.eval.controller;

import com.babybus.stu.eval.model.common.CommonResult;
import com.babybus.stu.eval.model.user.Faculty;
import com.babybus.stu.eval.service.user.FacultyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "教职工信息接口")
@RestController
@RequestMapping("/faculty")
public class FacultyController {
    @Autowired
    private FacultyService facultyService;

    @ApiOperation("插入教职工信息")
    @PostMapping("/insert")
    public CommonResult<?> insertFaculty(@RequestBody Faculty faculty) {
        try {
            // 将用户信息保存到数据库
            Integer affected = facultyService.insertFaculty(faculty);
            if (affected == 0) {
                return CommonResult.error(200,"插入失败");
            }
            return CommonResult.success(faculty, "插入成功");
        } catch (Exception e) {
            System.out.println(e);
            return CommonResult.error(500,"插入失败");
        }
    }

    @ApiOperation("获取教职工信息列表")
    @GetMapping("/get-list")
    public CommonResult<?> getFacultyList() {
        try {
            List<Faculty> facultyList = facultyService.getFacultyList();
            return CommonResult.success(facultyList, "获取成功");
        } catch (Exception e) {
            System.out.println(e);
            return CommonResult.error(500,"获取失败");
        }
    }

    @ApiOperation("根据用户ID，获取教职工信息")
    @GetMapping("/get")
    public CommonResult<?> getFacultyById(@RequestParam Integer userId) {
        try {
            Faculty faculty = facultyService.getFacultyById(userId);
            return CommonResult.success(faculty, "获取成功");
        } catch (Exception e) {
            System.out.println(e);
            return CommonResult.error(500,"获取失败");
        }
    }

    @ApiOperation("根据学号，获取教职工信息")
    @GetMapping("/get-by-card-id")
    public CommonResult<?> getFacultyByCardId(@RequestParam String cardId) {
        try {
            Faculty faculty = facultyService.getFacultyByCardId(cardId);
            return CommonResult.success(faculty, "获取成功");
        } catch (Exception e) {
            System.out.println(e);
            return CommonResult.error(500,"获取失败");
        }
    }

    @ApiOperation("更新教职工信息")
    @PutMapping("/update")
    public CommonResult<?> updateFaculty(@RequestBody Faculty faculty) {
        try {
            Integer affected = facultyService.updateFaculty(faculty);
            if (affected == 0) {
                return CommonResult.error(200,"更新失败");
            }
            return CommonResult.success(null, "更新成功");
        } catch (Exception e) {
            System.out.println(e);
            return CommonResult.error(500,"更新失败");
        }
    }

    @ApiOperation("根据用户ID，删除教职工信息")
    @DeleteMapping("/delete")
    public CommonResult<?> deleteFacultyById(@RequestParam Integer userId) {
        try {
            Integer affected = facultyService.deleteFacultyById(userId);
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
