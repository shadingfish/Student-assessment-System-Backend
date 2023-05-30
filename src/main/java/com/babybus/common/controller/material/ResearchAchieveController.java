package com.babybus.common.controller.material;

import com.babybus.common.model.CommonResult;
import com.babybus.common.model.material.ResearchAchieve;
import com.babybus.common.service.material.ResearchAchieveService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "科研成果")
@RestController
@RequestMapping("/research-achieve")
public class ResearchAchieveController {
    @Autowired
    private ResearchAchieveService researchAchieveService;

    @ApiOperation("插入科研成果")
    @PostMapping("/insert")
    public CommonResult<?> insertResearchAchieve(@RequestBody ResearchAchieve research) {
        try {
            // 将用户信息保存到数据库
            Integer affected = researchAchieveService.insertResearchAchieve(research);
            if (affected == 0) {
                return CommonResult.error(200,"插入失败");
            }
            return CommonResult.success(null, "插入成功");
        } catch (Exception e) {
            System.out.println(e.toString());
            return CommonResult.error(500,"插入失败");
        }
    }

    @ApiOperation("获取科研成果列表")
    @GetMapping("/get-list")
    public CommonResult<?> getResearchAchieveList(@RequestParam Integer stuId) {
        try {
            List<ResearchAchieve> researchList = researchAchieveService.getResearchAchieveList(stuId);
            return CommonResult.success(researchList, "获取成功");
        } catch (Exception e) {
            System.out.println(e.toString());
            return CommonResult.error(500,"获取失败");
        }
    }

    @ApiOperation("根据学生ID和学年获取科研成果")
    @GetMapping("/get")
    public CommonResult<?> getResearchAchieveById(@RequestParam Integer matId) {
        try {
            ResearchAchieve research = researchAchieveService.getResearchAchieveById(matId);
            if (research != null) {
                return CommonResult.success(research, "获取成功");
            } else {
                return CommonResult.error(200,"找不到该记录");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            return CommonResult.error(500,"获取失败");
        }

    }

    @ApiOperation("更新科研成果")
    @PutMapping("/update")
    public CommonResult<?> updateResearchAchieve(@RequestBody ResearchAchieve research) {
        try {
            Integer affected = researchAchieveService.updateResearchAchieve(research);
            if (affected == 0) {
                return CommonResult.error(200,"更新失败");
            }
            return CommonResult.success(null, "更新成功");
        } catch (Exception e) {
            System.out.println(e.toString());
            return CommonResult.error(500,"更新失败");
        }
    }

    @ApiOperation("删除科研成果")
    @DeleteMapping("/delete")
    public CommonResult<?> deleteResearchAchieveById(@RequestParam Integer matId) {
        try {
            Integer affected = researchAchieveService.deleteResearchAchieveById(matId);
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
