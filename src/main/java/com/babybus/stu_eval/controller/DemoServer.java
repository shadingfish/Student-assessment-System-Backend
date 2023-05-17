package com.babybus.stu_eval.controller;

import com.babybus.stu_eval.model.CommonResult;
import com.babybus.stu_eval.controller.vo.Demo.LoginReqVo;
import com.babybus.stu_eval.controller.vo.Demo.RespVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(tags = "演示接口")
@RestController
@RequestMapping("/my-api/demo")
public class DemoServer {
    @ApiOperation("Hello World接口")
    @GetMapping("/hello")
    public String hello() {
        return "Hello, world!";
    }

    @GetMapping("/login-req")
    public CommonResult<RespVo> hello(@RequestBody @Valid LoginReqVo reqVo) {
        RespVo loginRespVo = new RespVo();
        loginRespVo.setAccessToken("foo");
        loginRespVo.setRefreshToken("bar");

        CommonResult<RespVo> res = new CommonResult<>(loginRespVo);
        return res.success(loginRespVo);
    }
}
