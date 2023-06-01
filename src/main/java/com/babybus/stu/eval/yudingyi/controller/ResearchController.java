package com.babybus.stu.eval.yudingyi.controller;

import com.babybus.stu.eval.model.common.CommonResult;
import com.babybus.stu.eval.yudingyi.service.ResearchService;
import com.babybus.stu.eval.model.common.VO.Research.File;
import com.babybus.stu.eval.model.common.VO.Research.ResearchReqVo;
import com.babybus.stu.eval.model.common.VO.Research.Domain;

import com.babybus.stu.eval.yudingyi.model.DTO.Research.CheckResearch;
import com.babybus.stu.eval.model.material.Research;
import com.babybus.stu.eval.yudingyi.model.DTO.Research.ReturnResearch;
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
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/insert")
    public CommonResult<?> postResearch(@RequestBody @Valid ResearchReqVo researchReqVo){
        System.out.println(researchReqVo);

        //public Research(int stu_id, String ac_
        // year, String file_url, String output_name, int output_type, String category, int ranking, int level, Date output_time)

        List<Research> data;
        String msg;
        try{
            data = new ArrayList<>();
            for (Domain domain : researchReqVo.getDomains()) {
                data.add(new Research(Integer.parseInt(researchReqVo.getUID()), researchReqVo.getAc_year(), domain.getFileList()[0].name, domain.getFileList()[0].url, domain.output_name, domain.output_type, domain.category, domain.ranking, domain.level, domain.output_time));
            }

            System.out.println(data);
            int num = researchService.storeResReq(data);
            msg = "共插入了" + num + "条科研记录。";
            System.out.println(msg);

        } catch (Exception e ){
            System.out.println("后端上传错误：" + e.getMessage());
            return CommonResult.error(500, "后端上传错误");
        }

        return CommonResult.success(msg, "请求成功！");
    };

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/check")
    public List<CheckResearch> checkResearch(){
        List<CheckResearch> list = researchService.checkResearch();
        System.out.println(list);
        return list;
    };

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/get-list")
    public List<ReturnResearch> getResearchList(@RequestParam @Valid int stu_id){
        return  researchService.getResearchList(stu_id);
    };

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/delete")
    public String deleteResearch(@RequestParam @Valid int mat_id){

        return  "共删除了" + researchService.deleteResearch(mat_id) + "条记录。";
    };

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/retrieve")
    //ResearchReqVo
    public ResearchReqVo retrieveResearch(@RequestParam @Valid int stu_id){
        List<Research> res_list = researchService.retrieveResearch(stu_id);
        ArrayList<Domain> domainList = new ArrayList<>();
        for (Research research : res_list) {
            File temp = new File(research.name, research.fileUrl);
            File[] file = {temp};
            Domain domain = new Domain(String.valueOf(research.matId), research.output_name, research.output_type, research.category, research.ranking, research.level, research.output_time, file);
            domainList.add(domain);
        }

        ResearchReqVo researchReqVo = new ResearchReqVo(String.valueOf(res_list.get(0).stuId), res_list.get(0).acYear, domainList.toArray(new Domain[domainList.size()]));

        System.out.println("恢复完成：");
        System.out.println(researchReqVo);
        return researchReqVo;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
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
