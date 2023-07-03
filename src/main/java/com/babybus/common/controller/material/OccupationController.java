package com.babybus.common.controller.material;

import com.babybus.common.model.CommonResult;
import com.babybus.common.model.material.Competition;
import com.babybus.common.model.material.Occupation;
import com.babybus.common.model.user.Student;
import com.babybus.common.service.StudentService;
import com.babybus.common.service.material.OccupationService;
import com.babybus.yudingyi.util.JwtTokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "学生骨干岗位任职")
@RestController
@RequestMapping("/occupation")
public class OccupationController {
    @Autowired
    private OccupationService occupationService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    StudentService studentService;

    @ApiOperation("插入学生岗位任职记录")
    @PostMapping("/insert")
    public CommonResult<?> insertOccupation(@RequestBody Occupation occupation,@RequestHeader("Authorization")String token) {
        try {
            String cardId=jwtTokenUtil.getUsernameFromToken(token);
            occupation.setCardId(cardId);
            Student student=studentService.getStudentByCardId(cardId);
            occupation.setEvalStatus("待审核");
            occupation.setMatType("学生岗位");
            occupation.setStuId(student.getId());
            System.out.println(occupation);
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

    @ApiOperation("获取学生岗位任职记录列表")
    @GetMapping("/get-list")
    public CommonResult<?> getOccupationList(@RequestHeader("Authorization")String token) {
        try {
            String cardId=jwtTokenUtil.getUsernameFromToken(token);
            Integer stuId=studentService.getStudentByCardId(cardId).getId();
            List<Occupation> occupationList = occupationService.getOccupationList(stuId);
            return CommonResult.success(occupationList, "获取成功");
        } catch (Exception e) {
            System.out.println(e.toString());
            return CommonResult.error(500,"获取失败");
        }
    }
    @ApiOperation("根据cardId获取学生岗位任职记录列表")
    @GetMapping("/get-list-by-cardId")
    public CommonResult<?> getCompetitionListByCardId(@RequestParam String card_id) {
        try {
            Student student=studentService.getStudentByCardId(card_id);
            List<Occupation> occupationList=occupationService.getOccupationList(student.getId());
            return CommonResult.success(occupationList, "获取成功");
        } catch (Exception e) {
            System.out.println(e.toString());
            return CommonResult.error(500,"获取失败");
        }
    }
    @ApiOperation("根据学生ID和学年获取学生岗位任职记录")
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

    @ApiOperation("更新学生岗位任职记录")
    @PutMapping("/update")
    public CommonResult<?> updateOccupation(@RequestBody Occupation occupation) {
        try {
            System.out.println(occupation);
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

    @ApiOperation("删除学生岗位任职记录")
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
