package com.babybus.wuqile.controller;

import com.babybus.common.mapper.EvalRecordMapper;
import com.babybus.common.model.CommonResult;
import com.babybus.common.model.EvalRecord;
import com.babybus.common.model.user.Faculty;
import com.babybus.common.model.user.Student;
import com.babybus.common.service.FacultyService;
import com.babybus.common.service.StudentService;
import com.babybus.wangdy55.service.UserService;
import com.babybus.yudingyi.mapper.UserMapper;
import com.babybus.yudingyi.model.User;
import com.babybus.yudingyi.util.JwtTokenUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Api(tags = "学生综测成绩")
@RestController
@CrossOrigin
@RequestMapping("/api/eval-record")
public class EvalRecordController {
    @Autowired
    EvalRecordMapper evalRecordMapper;
    @Autowired
    JwtTokenUtil jwtTokenUtil;
    @Autowired
    UserService userService;
    @Autowired
    StudentService studentService;

    @Autowired
    FacultyService facultyService;
    @GetMapping("/get")
    public CommonResult<?> getEvalRecord(@RequestHeader("Authorization")String token, @RequestBody String acYear, @RequestBody String type){
        try{
            String cardId=jwtTokenUtil.getUsernameFromToken(token);
            User user=userService.getUserByCardId(cardId);
            System.out.println("获取的学年： "+acYear);
            System.out.println("获取的评审记录种类： "+type);
            System.out.println("获取的评审id： "+user.getId());
            List<EvalRecord> evalRecords=evalRecordMapper.getEvalRecord(type, user.getId(), acYear);
            return CommonResult.success(evalRecords,"获取成功");
        }catch(Exception e){
            e.printStackTrace();
            return CommonResult.error(500,"获取失败");
        }
    }

    @PostMapping("/insert")
    public CommonResult<?> insertEvalRecord(@RequestHeader("Authorization")String token, @RequestBody EvalRecord evalRecord){
        try{
            String cardId=jwtTokenUtil.getUsernameFromToken(token);
            User user=userService.getUserByCardId(cardId);
            Student student = studentService.getStudentByCardId(cardId);
            Faculty faculty=facultyService.getFacultyByCardId(user.getCardId());
            evalRecord.setJudgeId(faculty.getId());
            System.out.println("获取的评审记录种类： "+evalRecord.getMatType());
            System.out.println("获取的评审id： "+evalRecord.getJudgeId());
            System.out.println("获取的学年： "+evalRecord.getAcYear());
            evalRecord.setJudgeCardId(faculty.getCardId());
            evalRecord.setStuCardId(student.getCardId());
            evalRecord.setStuName(student.getName());
            List<EvalRecord> evalRecords=evalRecordMapper.getEvalRecord(evalRecord.getMatType(), evalRecord.getJudgeId(), evalRecord.getAcYear());
            for(EvalRecord ev:evalRecords){
                System.out.println(ev);
                if(Objects.equals(ev.getJudgeId(), evalRecord.getJudgeId()) && Objects.equals(ev.getMatType(), evalRecord.getMatType()) &&ev.getAcYear().equals(evalRecord.getAcYear()))
                    evalRecord.setId(ev.getId());
            }
            System.out.println(evalRecord);
            if(!(evalRecord.getId() ==null)){
                evalRecordMapper.updateEvalRecord(evalRecord);
                return CommonResult.success(evalRecord,"修改成功");
            }
            int res=evalRecordMapper.insertEvalRecord(evalRecord);
            return CommonResult.success(res,"插入成功");
        }catch(Exception e){
            e.printStackTrace();
            return CommonResult.error(403,"已经存在该记录");
        }
    }

    @PutMapping("/update")
    public CommonResult<?> updateEvalRecord(@RequestHeader("Authorization")String token, @RequestBody EvalRecord evalRecord){
        try{
            String cardId=jwtTokenUtil.getUsernameFromToken(token);
            User user=userService.getUserByCardId(cardId);
            evalRecord.setJudgeId(user.getId());
            System.out.println(evalRecord);
            evalRecordMapper.updateEvalRecord(evalRecord);
            return CommonResult.success(evalRecord,"修改成功");
        }catch(Exception e){
            e.printStackTrace();
            return CommonResult.error(403,"修改失败");
        }
    }


}
