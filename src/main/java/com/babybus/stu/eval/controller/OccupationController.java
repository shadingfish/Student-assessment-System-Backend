package com.babybus.stu.eval.controller;

import com.babybus.stu.eval.model.common.CommonResult;
import com.babybus.stu.eval.model.material.Occupation;
import com.babybus.stu.eval.service.material.OccupationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "学生骨干岗位任职情况接口")
@RestController
@RequestMapping("/occupation")
public class OccupationController {
    @Autowired
    private OccupationService occupationService;

    @ApiOperation("插入学生骨干岗位任职情况")
    @PostMapping("/insert")
    public CommonResult<?> insertOccupation(@RequestBody Occupation occupation) {
        try {
            // 将用户信息保存到数据库
            Integer affected = occupationService.insertOccupation(occupation);
            if (affected == 0) {
                return CommonResult.error(200,"插入失败");
            }
            return CommonResult.success(null, "插入成功");
        } catch (Exception e) {
            System.out.println(e.toString());
            return CommonResult.error(500,"插入失败");
        }
    }

    @ApiOperation("获取学生骨干岗位任职情况列表")
    @GetMapping("/get-list")
    public CommonResult<?> getOccupationList(@RequestParam Integer stuId) {
        try {
            List<Occupation> occupationList = occupationService.getOccupationList(stuId);
            return CommonResult.success(occupationList, "获取成功");
        } catch (Exception e) {
            System.out.println(e.toString());
            return CommonResult.error(500,"获取失败");
        }
    }

    @ApiOperation("根据学生ID和学年获取学生骨干岗位任职情况")
    @GetMapping("/get")
    public CommonResult<?> getOccupationById(@RequestParam Integer matId) {
        try {
            Occupation occupation = occupationService.getOccupationById(matId);
            if (occupation != null) {
                return CommonResult.success(occupation, "获取成功");
            } else {
                return CommonResult.error(200,"找不到该记录");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            return CommonResult.error(500,"获取失败");
        }

    }

    @ApiOperation("更新学生骨干岗位任职情况")
    @PutMapping("/update")
    public CommonResult<?> updateOccupation(@RequestBody Occupation occupation) {
        try {
            Integer affected = occupationService.updateOccupation(occupation);
            if (affected == 0) {
                return CommonResult.error(200,"更新失败");
            }
            return CommonResult.success(null, "更新成功");
        } catch (Exception e) {
            System.out.println(e.toString());
            return CommonResult.error(500,"更新失败");
        }
    }

    @ApiOperation("删除学生骨干岗位任职情况")
    @DeleteMapping("/delete")
    public CommonResult<?> deleteOccupationById(@RequestParam Integer matId) {
        try {
            Integer affected = occupationService.deleteOccupationById(matId);
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
