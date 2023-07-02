package com.babybus.common.controller.material;

import com.babybus.common.model.CommonResult;
import com.babybus.common.model.material.Competition;
import com.babybus.common.model.user.Student;
import com.babybus.common.service.StudentService;
import com.babybus.common.service.material.CompetitionService;
import com.babybus.yudingyi.util.JwtTokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "竞赛获奖")
@RestController
@RequestMapping("/competition")
public class CompetitionController {
    @Autowired
    private CompetitionService competitionService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private StudentService studentService;

    @ApiOperation("插入竞赛获奖记录")
    @PostMapping("/insert")
    public CommonResult<?> insertCompetition(@RequestBody Competition competition,@RequestHeader("Authorization") String token) {
        try {
            String cardId=jwtTokenUtil.getUsernameFromToken(token);
            competition.setCardId(cardId);
            Student student=studentService.getStudentByCardId(cardId);
            competition.setStuId(student.getId());
            competition.setEvalStatus("未评审");
            competition.setMatType("竞赛获奖");
            System.out.println(competition);

            // 将用户信息保存到数据库
            Integer affected = competitionService.insertCompetition(competition);
            if (affected == 0) {
                return CommonResult.error(200,"插入失败");
            }
            return CommonResult.success(null, "插入成功");
        } catch (Exception e) {
            System.out.println(e.toString());
            return CommonResult.error(500,"插入失败");
        }
    }

    @ApiOperation("获取竞赛获奖记录列表")
    @GetMapping("/get-list")
    public CommonResult<?> getCompetitionList(@RequestHeader("Authorization")String token) {
        try {
            String card_id=jwtTokenUtil.getUsernameFromToken(token);
            List<Competition> competitionList = competitionService.getCompetitionListByCardId(card_id);
            return CommonResult.success(competitionList, "获取成功");
        } catch (Exception e) {
            System.out.println(e.toString());
            return CommonResult.error(500,"获取失败");
        }
    }

    @ApiOperation("根据学生ID和学年获取竞赛获奖记录")
    @GetMapping("/get")
    public CommonResult<?> getCompetitionById(@RequestParam Integer matId) {
        try {
            Competition competition = competitionService.getCompetitionById(matId);
            if (competition != null) {
                return CommonResult.success(competition, "获取成功");
            } else {
                return CommonResult.error(200,"找不到该记录");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            return CommonResult.error(500,"获取失败");
        }

    }

    @ApiOperation("更新竞赛获奖记录")
    @PutMapping("/update")
    public CommonResult<?> updateCompetition(@RequestBody Competition competition) {
        try {
            Integer affected = competitionService.updateCompetition(competition);
            if (affected == 0) {
                return CommonResult.error(200,"更新失败");
            }
            return CommonResult.success(null, "更新成功");
        } catch (Exception e) {
            System.out.println(e.toString());
            return CommonResult.error(500,"更新失败");
        }
    }

    @ApiOperation("删除竞赛获奖记录")
    @DeleteMapping("/delete")
    public CommonResult<?> deleteCompetitionById(@RequestParam Integer matId) {
        try {
            Integer affected = competitionService.deleteCompetitionById(matId);
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
