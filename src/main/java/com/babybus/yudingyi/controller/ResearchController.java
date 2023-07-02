package com.babybus.yudingyi.controller;

import com.babybus.common.mapper.StudentMapper;
import com.babybus.common.model.CommonResult;
import com.babybus.common.model.user.Student;
import com.babybus.yudingyi.service.ResearchService;
import com.babybus.yudingyi.model.VO.Research.ResearchReqVo;
import com.babybus.yudingyi.model.DTO.Research.CheckResearch;
import com.babybus.yudingyi.model.Research;
import com.babybus.yudingyi.model.DTO.Research.ReturnResearch;
import com.babybus.yudingyi.util.JwtTokenUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Api(tags = "科研成果演示接口")
@RestController
@RequestMapping("/research")
public class ResearchController {
    @Autowired
    private ResearchService researchService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private StudentMapper studentMapper;

    @CrossOrigin
    @GetMapping ("/mylist")
    public CommonResult<?> getMyList(@RequestHeader("Authorization") String token){
        System.out.println("token: " + token);
        List<Research> researchList = new ArrayList<>();
        String msg = "";

        try{
            // 解析Authorization请求头中的JWT令牌 Bearer access_token
            String cardId = jwtTokenUtil.getUsernameFromToken(token);
            System.out.println("学工号：" + cardId);
            Student student = studentMapper.getStudentByCardId(cardId);
            System.out.println("查询到学生: " + student);
            researchList = researchService.getResearchList(student.getId());
            System.out.println("获取到列表：" + researchList);

        } catch (Exception e) {
            System.out.println("后端上传错误：" + e.getMessage());
            e.printStackTrace();
            return CommonResult.error(500, "后端获取错误");
        }

        return CommonResult.success(researchList, "请求成功！" + msg);
    };

    @CrossOrigin
    @PostMapping ("/insert")
    public CommonResult<?> postResearch(@RequestHeader("Authorization") String token, @RequestBody @Valid ResearchReqVo researchReqVo){

        System.out.println("token: " + token);
        System.out.println("前端请求: " + researchReqVo);
        String msg;
        List<Research> researchList = new ArrayList<>();
        try{
            // 解析Authorization请求头中的JWT令牌 Bearer access_token
            String cardId = jwtTokenUtil.getUsernameFromToken(token);
            System.out.println("学工号：" + cardId);
            Student student = studentMapper.getStudentByCardId(cardId);
            System.out.println("查询到学生: " + student);

            System.out.print("生成researchDTO");
            researchList.add(
                    new Research(student.getId(), cardId, researchReqVo.getAcYear(), "科研成果",
                            researchReqVo.getFileUrl(), researchReqVo.getFileName(), researchReqVo.getOutputName(),
                            researchReqVo.getOutputType(), researchReqVo.getCategory(), researchReqVo.getDescription(),
                            researchReqVo.getOutputTime()));
            System.out.println(researchList);

            int num = researchService.storeResReq(researchList);

            msg = "共插入了" + num + "条科研记录。";
            System.out.println(msg);

        } catch (Exception e){
            System.out.println("后端上传错误：" + e.getMessage());
            e.printStackTrace();
            return CommonResult.error(500, "后端上传错误");
        }

        return CommonResult.success(researchList, "请求成功！" + msg);
    };

    @CrossOrigin
    @GetMapping("/check")
    public List<CheckResearch> checkResearch(){
        List<CheckResearch> list = researchService.checkResearch();
        System.out.println(list);
        return list;
    };

    @CrossOrigin
    @GetMapping("/get-list")
    public List<Research> getResearchList(@RequestParam @Valid int stu_id){
        return  researchService.getResearchList(stu_id);
    };

    @CrossOrigin
    @GetMapping("/delete")
    public String deleteResearch(@RequestParam("id") @Valid int id){

        return  "共删除了" + researchService.deleteResearch(id) + "条记录。";
    };

//    @CrossOrigin(origins = "*", allowedHeaders = "*")
//    @GetMapping("/retrieve")
//    //ResearchReqVo
//    public ResearchReqVo retrieveResearch(@RequestParam @Valid int stu_id){
//        List<Research> res_list = researchService.retrieveResearch(stu_id);
//        ArrayList<Domain> domainList = new ArrayList<>();
//        for (Research research : res_list) {
//            File temp = new File(research.name, research.fileUrl);
//            File[] file = {temp};
//            Domain domain = new Domain(String.valueOf(research.matId), research.output_name, research.output_type, research.category, research.ranking, research.level, research.output_time, file);
//            domainList.add(domain);
//        }
//
//        ResearchReqVo researchReqVo = new ResearchReqVo(String.valueOf(res_list.get(0).stuId), res_list.get(0).acYear, domainList.toArray(new Domain[domainList.size()]));
//
//        System.out.println("恢复完成：");
//        System.out.println(researchReqVo);
//        return researchReqVo;
//    }

    @CrossOrigin
    @PostMapping("/give-score")
    public CommonResult<?> giveResearchScore(@RequestBody int[] judge){

        String msg;
        try{System.out.println(Arrays.toString(judge));
            msg = "共更新了" + researchService.giveResearchScore(judge[0], judge[1]) + "条数据。";
            System.out.println(msg);
        } catch (Exception e){
            System.out.println("后端打分错误：" + e.getMessage());
            return CommonResult.error(500, "后端打分错误");
        }

        return CommonResult.success(msg, "请求成功！");
    };

//    @CrossOrigin(origins = "*", allowedHeaders = "*")
//    @PostMapping("/checkResearch")
//    public List<CheckResearch> checkResearch(@RequestParam @Valid String UID){
//        return  userService.checkResearch(UID);
//    };
}
