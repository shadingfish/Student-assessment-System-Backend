package com.babybus.stu_eval.controller;

import com.babybus.stu_eval.controller.vo.Demo.RespVo;
import com.babybus.stu_eval.controller.vo.Research.ResearchReqVo;
import com.babybus.stu_eval.controller.vo.Research.domain;
import com.babybus.stu_eval.model.CommonResult;
import com.babybus.stu_eval.model.Research.CheckResearch;
import com.babybus.stu_eval.model.Research.Research;
import com.babybus.stu_eval.model.Research.ReturnResearch;
import com.babybus.stu_eval.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Api(tags = "科研成果演示接口")
@RestController
public class ResearchController {
    @Autowired
    private UserService userService;
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/postResearch")
    public CommonResult<?> postResearch(@RequestBody @Valid ResearchReqVo researchReqVo){
        System.out.println(researchReqVo);

        //public Research(int stu_id, String ac_year, String file_url, String output_name, int output_type, String category, int ranking, int level, Date output_time)

        try{
            List<Research> data = new ArrayList<>();
            for (domain domain : researchReqVo.getDomains()) {
                data.add(new Research(Integer.parseInt(researchReqVo.getUID()), researchReqVo.getAc_year(), domain.getFileList()[0].url, domain.output_name, domain.output_type, domain.category, domain.ranking, domain.level, domain.output_time));
            }

            System.out.println(data);
            int num = userService.storeResReq(data);

            System.out.println("共插入了" + num + "条科研记录。");
        } catch (Exception e ){
            System.out.println("后端上传错误：" + e.getMessage());
            return CommonResult.error(500, "后端上传错误");
        }

        RespVo researchRespVo = new RespVo();
        researchRespVo.setAccessToken("yudingyi123");
        researchRespVo.setRefreshToken("yudingyi321");

        CommonResult<RespVo> res = new CommonResult<>(researchRespVo);
        return res.success(researchRespVo);
    };

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/checkResearch")
    public List<CheckResearch> checkResearch(){
        List<CheckResearch> list = userService.checkResearch();
        System.out.println(list);
        return list;
    };

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/getResearchList")
    public List<ReturnResearch> getResearchList(@RequestParam @Valid int stu_id){
        return  userService.getResearchList(stu_id);
    };

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/giveResearchScore")
    public CommonResult<?> giveResearchScore(@RequestBody int[] judge){

        try{System.out.println(Arrays.toString(judge));
            String resp = "共更新了" + userService.giveResearchScore(judge[0], judge[1]) + "条数据。";
            System.out.println(resp);
        } catch (Exception e){
            System.out.println("后端打分错误：" + e.getMessage());
            return CommonResult.error(500, "后端打分错误");
        }

        RespVo researchRespVo = new RespVo();
        researchRespVo.setAccessToken("yudingyi123");
        researchRespVo.setRefreshToken("yudingyi321");

        CommonResult<RespVo> res = new CommonResult<>(researchRespVo);
        return res.success(researchRespVo);
    };

//    @CrossOrigin(origins = "*", allowedHeaders = "*")
//    @PostMapping("/checkResearch")
//    public List<CheckResearch> checkResearch(@RequestParam @Valid String UID){
//        return  userService.checkResearch(UID);
//    };
}
