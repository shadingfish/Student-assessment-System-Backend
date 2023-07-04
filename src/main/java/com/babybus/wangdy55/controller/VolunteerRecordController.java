package com.babybus.wangdy55.controller;

import com.babybus.common.model.CommonResult;
import com.babybus.common.model.material.VolunteerActivity;
import com.babybus.common.model.user.Student;
import com.babybus.common.service.StudentService;
import com.babybus.wangdy55.model.DTO.EvalRecordDto;
import com.babybus.wangdy55.model.DTO.VolunteerRecordDto;
import com.babybus.wangdy55.service.VolunteerRecordService;
import com.babybus.wangdy55.service.VolunteerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "志愿服务活动评审")
@RestController
@RequestMapping("/eval/volunteer")
public class VolunteerRecordController {
    @Autowired
    VolunteerRecordService recordService;
    @Autowired
    VolunteerService volunteerService;
    @Autowired
    StudentService studentService;

    // 获取个人总结评审记录列表
    @GetMapping("/list")
    CommonResult<List<VolunteerRecordDto>> getVolunteerRecordList() {
        List<VolunteerRecordDto> list = recordService.getVolunteerRecordList();
        return CommonResult.success(list, "获取成功");
    }

    // 根据学生 ID 获取学生志愿服务记录列表
    @GetMapping("/{cardId}")
    CommonResult<List<VolunteerActivity>> getVolunteerActivity(@PathVariable("cardId") String cardId) {
        Student student = studentService.getStudentByCardId(cardId);
        List<VolunteerActivity> volunteerActivityList = volunteerService.getVolunteerActivityList(student.getId(), "2022-2023");
        return CommonResult.success(volunteerActivityList, "获取成功");
    }

    @PutMapping
    CommonResult<String> updateVolunteerRecord(@RequestBody EvalRecordDto recordDto) {
        recordService.updateVolunteerRecord(recordDto);
        return CommonResult.success(null, "修改成功");
    }
}
