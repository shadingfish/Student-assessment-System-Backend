package com.babybus.common.controller.material;

import com.babybus.common.model.CommonResult;
import com.babybus.common.model.material.VolunteerActivity;
import com.babybus.common.service.material.VolunteerActivityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "志愿服务活动")
@RestController
@RequestMapping("/volunteer-activity")
public class VolunteerActivityController {
    @Autowired
    private VolunteerActivityService volunteerActivityService;

    @ApiOperation("插入志愿服务活动记录")
    @PostMapping("/insert")
    public CommonResult<?> insertVolunteerActivity(@RequestBody VolunteerActivity volunteer) {
        try {
            // 将用户信息保存到数据库
            Integer affected = volunteerActivityService.insertVolunteerActivity(volunteer);
            if (affected == 0) {
                return CommonResult.error(200,"插入失败");
            }
            return CommonResult.success(null, "插入成功");
        } catch (Exception e) {
            System.out.println(e.toString());
            return CommonResult.error(500,"插入失败");
        }
    }

    @ApiOperation("获取志愿服务活动记录列表")
    @GetMapping("/get-list")
    public CommonResult<?> getVolunteerActivityList(@RequestParam Integer stuId) {
        try {
            List<VolunteerActivity> volunteerList = volunteerActivityService.getVolunteerActivityList(stuId);
            return CommonResult.success(volunteerList, "获取成功");
        } catch (Exception e) {
            System.out.println(e.toString());
            return CommonResult.error(500,"获取失败");
        }
    }

    @ApiOperation("根据学生ID和学年获取志愿服务活动记录")
    @GetMapping("/get")
    public CommonResult<?> getVolunteerActivityById(@RequestParam Integer matId) {
        try {
            VolunteerActivity volunteer = volunteerActivityService.getVolunteerActivityById(matId);
            if (volunteer != null) {
                return CommonResult.success(volunteer, "获取成功");
            } else {
                return CommonResult.error(200,"找不到该记录");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            return CommonResult.error(500,"获取失败");
        }

    }

    @ApiOperation("更新志愿服务活动记录")
    @PutMapping("/update")
    public CommonResult<?> updateVolunteerActivity(@RequestBody VolunteerActivity volunteer) {
        try {
            Integer affected = volunteerActivityService.updateVolunteerActivity(volunteer);
            if (affected == 0) {
                return CommonResult.error(200,"更新失败");
            }
            return CommonResult.success(null, "更新成功");
        } catch (Exception e) {
            System.out.println(e.toString());
            return CommonResult.error(500,"更新失败");
        }
    }

    @ApiOperation("删除志愿服务活动记录")
    @DeleteMapping("/delete")
    public CommonResult<?> deleteVolunteerActivityById(@RequestParam Integer matId) {
        try {
            Integer affected = volunteerActivityService.deleteVolunteerActivityById(matId);
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
