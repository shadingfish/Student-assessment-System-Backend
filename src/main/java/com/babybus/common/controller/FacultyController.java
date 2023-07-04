package com.babybus.common.controller;

import com.babybus.common.model.CommonResult;
import com.babybus.common.model.user.Faculty;
import com.babybus.common.service.FacultyService;
import com.babybus.wanglingyu.model.FacultyImportExcel;
import com.babybus.wanglingyu.model.PageBean;
import com.babybus.wanglingyu.util.ExcelUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Api(tags = {"教职工信息"})
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

    @ApiOperation("根据ID，获取教职工信息")
    @GetMapping("/get")
    public CommonResult<?> getFacultyById(@RequestParam Integer userId) {
        try {
            Faculty faculty = facultyService.getFacultyById(userId);
            if (faculty != null) {
                return CommonResult.success(faculty, "获取成功");
            } else {
                return CommonResult.error(200,"找不到该记录");
            }
        } catch (Exception e) {
            System.out.println(e);
            return CommonResult.error(500,"获取失败");
        }
    }

    @ApiOperation("根据工号，获取教职工信息")
    @GetMapping("/get-by-card-id")
    public CommonResult<?> getFacultyByCardId(@RequestParam String cardId) {
        try {
            Faculty faculty = facultyService.getFacultyByCardId(cardId);
            if (faculty != null) {
                return CommonResult.success(faculty, "获取成功");
            } else {
                return CommonResult.error(200,"找不到该记录");
            }
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

    @ApiOperation("根据ID，删除教职工信息")
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

    @PostMapping("/import")
    public CommonResult<?> importExcel(MultipartFile file) throws Exception {
        List<FacultyImportExcel> list = ExcelUtils.read(file, FacultyImportExcel.class);
        facultyService.importFacultyList(list);
        return CommonResult.success("ok", "ok");
    }

    @GetMapping("/page")
    public CommonResult<?> getPage(@RequestParam(defaultValue = "1") Integer
                                           page,
                                   @RequestParam(defaultValue = "10") Integer
                                           pageSize) {
        PageBean pageBean = facultyService.getPage(page, pageSize);
        return CommonResult.success(pageBean, "ok");
    }
}
