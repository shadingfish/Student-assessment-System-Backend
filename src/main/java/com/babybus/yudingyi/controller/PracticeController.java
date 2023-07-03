package com.babybus.yudingyi.controller;

import com.babybus.common.model.CommonResult;
import com.babybus.common.model.EvalRecord;
import com.babybus.common.model.user.Faculty;
import com.babybus.common.model.user.Student;
import com.babybus.common.service.FacultyService;
import com.babybus.common.service.StudentService;
import com.babybus.yudingyi.model.DTO.Check;
import com.babybus.yudingyi.model.Practice;
import com.babybus.yudingyi.service.EvalRecordService;
import com.babybus.yudingyi.service.PracticeService;
import com.babybus.yudingyi.util.JwtTokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Random;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Api(tags = "社会实践")
@RestController
@RequestMapping("/practice")
public class PracticeController {
    @Autowired
    private PracticeService practiceService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private StudentService studentService;
    @Autowired
    private FacultyService facultyService;
    @Autowired
    private EvalRecordService evalRecordService;
    //以下全部是学生操作
    @ApiOperation("根据学生ID和学年获取社会实践记录")
    @GetMapping("/get")
    public CommonResult<?> getPracticeById(@RequestParam Integer matId) {
        try {
            Practice practice = practiceService.getPracticeById(matId);
            if (practice != null) {
                return CommonResult.success(practice, "获取成功");
            } else {
                return CommonResult.error(200,"找不到该记录");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            return CommonResult.error(500,"获取失败");
        }

    }

    @ApiOperation("更新社会实践记录")
    @PutMapping("/update")
    public CommonResult<?> updatePractice(@RequestBody Practice practice) {
        try {
            Integer affected = practiceService.updatePractice(practice);
            if (affected == 0) {
                return CommonResult.error(200,"更新失败");
            }
            return CommonResult.success(null, "更新成功");
        } catch (Exception e) {
            System.out.println(e.toString());
            return CommonResult.error(500,"更新失败");
        }
    }

    @ApiOperation("插入社会实践记录")
    @CrossOrigin
    @PostMapping("/insert")
    public CommonResult<?> postPractice(@RequestHeader("Authorization") String token, @RequestBody Practice practice){
        String msg;
        try{
            System.out.println("接收到前端请求：" + practice);
            String card_id = jwtTokenUtil.getUsernameFromToken(token);
            Student student = studentService.getStudentByCardId(card_id);
            System.out.println("检测到学生：" + student);
            practice.setStuId(student.getId());
            practice.setCardId(student.getCardId());
            practice.setMatType("社会实践");
            int num = practiceService.insertPractice(practice);
            msg = "共插入了" + num + "条实践记录。";
            System.out.println(msg);

            EvalRecord evalRecord = evalRecordService.getEvalByType(student.getId(),"社会实践");
            if(evalRecord == null){
                List<Faculty> facultyList = facultyService.getFacultyByRole("实践评委");
                Random random = new Random();
                Faculty faculty = facultyList.get(random.nextInt(facultyList.size()));
                evalRecord = new EvalRecord(0, student.getId(), student.getCardId(), student.getName(), faculty.getId(), faculty.getCardId(), practice.getAcYear(), "社会实践", "待审核", 0, new Date(), "无评语");
                evalRecordService.insertEvalRecord(evalRecord);
            }

            return CommonResult.success(practice, "请求成功！" + msg);
        } catch (Exception e ){
            e.printStackTrace();
            System.out.println("后端上传错误：" + e.getMessage());
            return CommonResult.error(500, "后端上传错误");
        }
    };

    @ApiOperation("删除社会实践记录")
    @CrossOrigin
    @PostMapping("/delete")
    public CommonResult<?> deletePractice(@RequestHeader("Authorization") String token, @RequestParam("id") int id){
        try{
            String card_id = jwtTokenUtil.getUsernameFromToken(token);
            Student student = studentService.getStudentByCardId(card_id);
            System.out.println("检测到学生：" + student);
            Practice practice = practiceService.getPracticeById(id);
            System.out.println(id + "欲删除记录为：" + practice);
            if(practice.getStuId() == student.getId()){
                int num = practiceService.deletePracticeById(id);
                return CommonResult.success(practice, "成功删除" + num + "条记录。");
            }else{
                return CommonResult.error(311, "记录归属错误，无法删除");
            }
        }catch (Exception e ){
            e.printStackTrace();
            System.out.println("后端上传错误：" + e.getMessage());
            return CommonResult.error(500, "后端上传错误");
        }
    };

    @ApiOperation("学生获取社会实践记录列表")
    @CrossOrigin
    @GetMapping("/mylist")
    public CommonResult<?> getResList(@RequestHeader("Authorization") String token){
        try{
            String card_id = jwtTokenUtil.getUsernameFromToken(token);
            Student student = studentService.getStudentByCardId(card_id);
            System.out.println("检测到学生：" + student);

            List<Practice> practiceList = practiceService.getPracticeList(student.getId());

            return CommonResult.success(practiceList, "成功获取到" + student.getName() + "的实践信息");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return CommonResult.error(301, "实践获取出错：" + e.getMessage());
        }
    };

    //以下全部是评委操作
    @CrossOrigin
    @GetMapping("/check")
    public List<Check> checkPractice(@RequestHeader("Authorization") String token){
        String card_id = jwtTokenUtil.getUsernameFromToken(token);
        Faculty faculty = facultyService.getFacultyByCardId(card_id);
        System.out.println("检测到职员：" + faculty);
        List<Check> list = practiceService.checkPractice(faculty.getId());
        System.out.println(list);
        return list;
    };

    @CrossOrigin
    @PostMapping("/give-score")
    public CommonResult<?> givePracticeScore(@RequestHeader("Authorization") String token, @RequestBody int[] judge){
        String card_id = jwtTokenUtil.getUsernameFromToken(token);
        Faculty faculty = facultyService.getFacultyByCardId(card_id);
        System.out.println("检测到职员：" + faculty);
        String msg;
        try{System.out.println(Arrays.toString(judge));
            msg = "共更新了" + practiceService.givePracticeScore(judge[0], judge[1]) + "条数据。";
            System.out.println(msg);

            EvalRecord evalRecord = evalRecordService.getEvalRecord(judge[0], faculty.getId());
            Student student = studentService.getStudentById(judge[0]);
            List<Practice> practiceList = practiceService.getPracticeList(student.getId());
            if(evalRecord == null){
                evalRecord = new EvalRecord(0, judge[0], student.getCardId(), student.getName(), faculty.getId(), faculty.getCardId(), practiceList.get(0).acYear, "社会实践", "已通过", judge[1], new Date(), "无评语");
                evalRecordService.insertEvalRecord(evalRecord);
            } else{
                evalRecord = new EvalRecord(evalRecord.getId(), judge[0], student.getCardId(), student.getName(), faculty.getId(), faculty.getCardId(), practiceList.get(0).acYear, "社会实践", "已通过", judge[1], new Date(), "无评语");
                evalRecordService.updateEvalRecord(evalRecord);
            }

        } catch (Exception e){
            System.out.println("后端打分错误：" + e.getMessage());
            return CommonResult.error(500, "后端打分错误");
        }

        return CommonResult.success(msg, "请求成功！");
    };

    @ApiOperation("评委获取社会实践记录列表")
    @CrossOrigin
    @GetMapping("/get-list")
    public List<Practice> getResearchList(@RequestHeader("Authorization") String token, @RequestParam("id") int id){
        String card_id = jwtTokenUtil.getUsernameFromToken(token);
        Faculty faculty = facultyService.getFacultyByCardId(card_id);
        System.out.println("检测到职员：" + faculty);
        return  practiceService.getPracticeList(id);
    };

}
