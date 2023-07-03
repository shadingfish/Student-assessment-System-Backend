package com.babybus.wangdy55.controller;

import com.babybus.common.model.CommonResult;
import com.babybus.common.model.material.VolunteerActivity;
import com.babybus.common.model.user.Student;
import com.babybus.common.service.StudentService;
import com.babybus.wangdy55.controller.vo.VolunteerActivityVo;
import com.babybus.wangdy55.service.VolunteerService;
import com.babybus.yudingyi.util.JwtTokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.List;

@Api(tags = "志愿服务活动")
@RestController
@RequestMapping("/volunteer")
public class VolunteerController {
    @Autowired
    private VolunteerService volunteerService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private StudentService studentService;

    @ApiOperation("添加志愿服务活动记录")
    @PostMapping
    public CommonResult<Integer> addVolunteerActivity(@RequestHeader("Authorization") String accessToken, @RequestBody VolunteerActivityVo volunteerActivityVo) {
        try {
            String cardId = jwtTokenUtil.getUsernameFromToken(accessToken);
            Student student = studentService.getStudentByCardId(cardId);
            Integer affected = volunteerService.addVolunteerActivity(student.getId(), volunteerActivityVo);
            if (affected == 0) {
                return CommonResult.error(501,"提交失败");
            }
            return CommonResult.success(null, "提交成功");
        } catch (Exception e) {
            System.out.println(e.toString());
            return CommonResult.error(500,"提交失败");
        }
    }

//    @PostMapping("/${targetId}")
//    public CommonResult<?> addVolunteerFile(@RequestHeader("Authorization") String accessToken, @PathVariable("targetId") int targetId, @RequestBody File file) {
//        return CommonResult.success(volunteerService.addVolunteerFile(targetId, file), "上传成功");
//    }

    @ApiOperation("查询个人志愿服务活动列表")
    @GetMapping("/list")
    public CommonResult<?> getSummaryList(@RequestHeader("Authorization") String accessToken) {
        try {
            String cardId = jwtTokenUtil.getUsernameFromToken(accessToken);
            Student student = studentService.getStudentByCardId(cardId);
            List<VolunteerActivity> volunteerActivityList = volunteerService.getVolunteerActivityList(student.getId(), "2022-2023");
            return CommonResult.success(volunteerActivityList, "获取成功");
        } catch (Exception e) {
            System.out.println(e.toString());
            return CommonResult.error(500,"获取失败");
        }
    }

    @ApiOperation("根据 ID 查询志愿服务活动")
    @GetMapping
    public CommonResult<?> getSummary(@RequestParam Integer id) {
        try {
            VolunteerActivity volunteerActivity = volunteerService.getVolunteerActivityById(id);
            if (volunteerActivity != null) {
                return CommonResult.success(volunteerActivity, "获取成功");
            } else {
                return CommonResult.error(200,"找不到该记录");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            return CommonResult.error(500,"获取失败");
        }

    }
}
