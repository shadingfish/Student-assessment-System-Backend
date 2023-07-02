package com.babybus.yudingyi.controller;

import com.babybus.common.model.CommonResult;
import com.babybus.common.model.EvalRecord;
import com.babybus.common.model.user.Faculty;
import com.babybus.common.model.user.Student;
import com.babybus.common.service.FacultyService;
import com.babybus.common.service.StudentService;
import com.babybus.yudingyi.service.EvalRecordService;
import com.babybus.yudingyi.service.ResearchService;

import com.babybus.yudingyi.model.DTO.Check;
import com.babybus.yudingyi.model.Research;
import com.babybus.yudingyi.util.JwtTokenUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Api(tags = "科研成果演示接口")
@RestController
@RequestMapping("/research")
public class ResearchController {
    @Autowired
    private ResearchService researchService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private StudentService studentService;
    @Autowired
    private FacultyService facultyService;
    @Autowired
    private EvalRecordService evalRecordService;

    @CrossOrigin
    @PostMapping("/insert")
    public CommonResult<?> postResearch(@RequestHeader("Authorization") String token, @RequestBody Research research){
        String msg;
        try{
            System.out.println("接收到前端请求：" + research);
            String card_id = jwtTokenUtil.getUsernameFromToken(token);
            Student student = studentService.getStudentByCardId(card_id);
            System.out.println("检测到学生：" + student);
            research.setStuId(student.getId());
            research.setCardId(student.getCardId());
            research.setMatType("科研成果");
            int num = researchService.storeResReq(research);
            msg = "共插入了" + num + "条科研记录。";
            System.out.println(msg);

            EvalRecord evalRecord = evalRecordService.getEvalByType(student.getId(),"科研成果");
            if(evalRecord == null){
                List<Faculty> facultyList = facultyService.getFacultyByRole("科研评委");
                Random random = new Random();
                Faculty faculty = facultyList.get(random.nextInt(facultyList.size()));
                evalRecord = new EvalRecord(0, student.getId(), student.getCardId(), student.getName(), faculty.getId(), faculty.getCardId(), research.getAcYear(), "科研成果", "待审核", 0, new Date(), "无评语");
                evalRecordService.insertEvalRecord(evalRecord);
            }

        } catch (Exception e ){
            System.out.println("后端上传错误：" + e.getMessage());
            return CommonResult.error(500, "后端上传错误");
        }

        return CommonResult.success(msg, "请求成功！");
    };

    @CrossOrigin
    @GetMapping("/check")
    public List<Check> checkResearch(@RequestHeader("Authorization") String token){
        String card_id = jwtTokenUtil.getUsernameFromToken(token);
        Faculty faculty = facultyService.getFacultyByCardId(card_id);
        System.out.println("检测到职员：" + faculty);
        List<Check> list = researchService.checkResearch(faculty.getId());
        System.out.println(list);
        return list;
    };

    @CrossOrigin
    @PostMapping("/delete")
    public CommonResult<?> deleteResearch(@RequestHeader("Authorization") String token, @RequestParam("id") int id){
        try{
            String card_id = jwtTokenUtil.getUsernameFromToken(token);
            Student student = studentService.getStudentByCardId(card_id);
            System.out.println("检测到学生：" + student);
            Research research = researchService.getById(id);
            System.out.println(id + "欲删除记录为：" + research);
            if(research.getStuId() == student.getId()){
                int num = researchService.deleteResearch(id);
                return CommonResult.success(research, "成功删除" + num + "条记录。");
            }else{
                return CommonResult.error(311, "记录归属错误，无法删除");
            }
        }catch (Exception e ){
            e.printStackTrace();
            System.out.println("后端上传错误：" + e.getMessage());
            return CommonResult.error(500, "后端上传错误");
        }
    };

    @CrossOrigin
    @PostMapping("/give-score")
    public CommonResult<?> giveResearchScore(@RequestHeader("Authorization") String token, @RequestBody int[] judge){
        String card_id = jwtTokenUtil.getUsernameFromToken(token);
        Faculty faculty = facultyService.getFacultyByCardId(card_id);
        System.out.println("检测到职员：" + faculty);
        String msg;
        try{
            System.out.println(Arrays.toString(judge));
            msg = "共更新了" + researchService.giveResearchScore(judge[0], judge[1]) + "条数据。";
            System.out.println(msg);
            EvalRecord evalRecord = evalRecordService.getEvalRecord(judge[0], faculty.getId());
            Student student = studentService.getStudentById(judge[0]);
            List<Research> researchList = researchService.getResearchList(student.getId());
            if(evalRecord == null){
                evalRecord = new EvalRecord(0, judge[0], student.getCardId(), student.getName(), faculty.getId(), faculty.getCardId(), researchList.get(0).acYear, "科研成果", "已通过", judge[1], new Date(), "无评语");
                evalRecordService.insertEvalRecord(evalRecord);
            } else{
                evalRecord = new EvalRecord(evalRecord.getId(), judge[0], student.getCardId(), student.getName(), faculty.getId(), faculty.getCardId(), researchList.get(0).acYear, "科研成果", "已通过", judge[1], new Date(), "无评语");
                evalRecordService.updateEvalRecord(evalRecord);
            }
        } catch (Exception e){
            System.out.println("后端打分错误：" + e.getMessage());
            return CommonResult.error(500, "后端打分错误");
        }

        return CommonResult.success(msg, "请求成功！");
    };


    @CrossOrigin
    @GetMapping("/mylist")
    public CommonResult<?> getResList(@RequestHeader("Authorization") String token){
        try{
            String card_id = jwtTokenUtil.getUsernameFromToken(token);
            Student student = studentService.getStudentByCardId(card_id);
            System.out.println("检测到学生：" + student);

            List<Research> researchList = researchService.getResearchList(student.getId());

            return CommonResult.success(researchList, "成功获取到" + student.getName() + "的科研信息");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return CommonResult.error(301, "科研提交出错：" + e.getMessage());
        }
    };
    @CrossOrigin
    @GetMapping("/get-list")
    public List<Research> getResearchList(@RequestHeader("Authorization") String token, @RequestParam("id") int id){
        String card_id = jwtTokenUtil.getUsernameFromToken(token);
        Faculty faculty = facultyService.getFacultyByCardId(card_id);
        System.out.println("检测到职员：" + faculty);
        return  researchService.getResearchList(id);
    };

//    @CrossOrigin(origins = "*", allowedHeaders = "*")
//    @PostMapping("/checkResearch")
//    public List<CheckResearch> checkResearch(@RequestParam @Valid String UID){
//        return  userService.checkResearch(UID);
//    };
}
