package com.babybus.stu_eval.controller;

import com.babybus.stu_eval.controller.vo.Demo.RespVo;
import com.babybus.stu_eval.controller.vo.Research.ResearchReqVo;
import com.babybus.stu_eval.model.CommonResult;
import com.babybus.stu_eval.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Api(tags = "科研成果演示接口")
@RestController
public class ResearchController {
    @Autowired
    private UserService userService;
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/postResearch")
    public CommonResult<RespVo> checkLogin(@RequestBody @Valid ResearchReqVo researchReqVo){
        System.out.println(researchReqVo);


        RespVo researchRespVo = new RespVo();
        researchRespVo.setAccessToken("post research");
        researchRespVo.setRefreshToken("post research");
        CommonResult<RespVo> res = new CommonResult<>(researchRespVo);
        return res.success(researchRespVo);
    };
}
