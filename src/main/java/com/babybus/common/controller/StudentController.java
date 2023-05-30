package com.babybus.common.controller;

import com.babybus.common.model.CommonResult;
import com.babybus.common.model.user.Student;
import com.babybus.common.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"学生信息"})
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @ApiOperation(value = "插入学生信息", notes = "插入学生信息后返回新增对象")
    @PostMapping("/insert")
    public CommonResult<?> insertStudent(@RequestBody Student student) {
        try {
            // 将用户信息保存到数据库
            Integer affected = studentService.insertStudent(student);
            if (affected == 0) {
                return CommonResult.error(200,"插入失败");
            }
            return CommonResult.success(student, "插入成功");
        } catch (Exception e) {
            System.out.println(e);
            return CommonResult.error(500,"插入失败");
        }
    }

    @ApiOperation("获取学生信息列表")
    @GetMapping("/get-list")
    public CommonResult<?> getStudentList() {
        try {
            List<Student> studentList = studentService.getStudentList();
            return CommonResult.success(studentList, "获取成功");
        } catch (Exception e) {
            System.out.println(e);
            return CommonResult.error(500,"获取失败");
        }
    }

    @ApiOperation("根据ID，获取学生信息")
    @GetMapping("/get")
    public CommonResult<?> getStudentById(@RequestParam Integer userId) {
        try {
            Student student = studentService.getStudentById(userId);
            if (student != null) {
                return CommonResult.success(student, "获取成功");
            } else {
                return CommonResult.error(200,"找不到该记录");
            }
        } catch (Exception e) {
            System.out.println(e);
            return CommonResult.error(500,"获取失败");
        }
    }

    @ApiOperation("根据学号，获取学生信息")
    @GetMapping("/get-by-card-id")
    public CommonResult<?> getStudentByCardId(@RequestParam String cardId) {
        try {
            Student student = studentService.getStudentByCardId(cardId);
            if (student != null) {
                return CommonResult.success(student, "获取成功");
            } else {
                return CommonResult.error(200,"找不到该记录");
            }
        } catch (Exception e) {
            System.out.println(e);
            return CommonResult.error(500,"获取失败");
        }
    }

    @ApiOperation("更新学生信息")
    @PutMapping("/update")
    public CommonResult<?> updateStudent(@RequestBody Student student) {
        try {
            Integer affected = studentService.updateStudent(student);
            if (affected == 0) {
                return CommonResult.error(200,"更新失败");
            }
            return CommonResult.success(null, "更新成功");
        } catch (Exception e) {
            System.out.println(e);
            return CommonResult.error(500,"更新失败");
        }
    }

    @ApiOperation("根据ID，删除学生信息")
    @DeleteMapping("/delete")
    public CommonResult<?> deleteStudentById(@RequestParam Integer userId) {
        try {
            Integer affected = studentService.deleteStudentById(userId);
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
