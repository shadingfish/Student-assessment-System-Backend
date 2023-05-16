package com.babybus.stu_eval.controller;

import com.babybus.stu_eval.model.CommonResult;
import com.babybus.stu_eval.model.LoginReqVo;
import com.babybus.stu_eval.model.LoginRespVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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
    public CommonResult<LoginRespVo> hello(@RequestBody @Valid LoginReqVo reqVo) {
        LoginRespVo loginRespVo = new LoginRespVo();
        loginRespVo.setAccessToken("foo");
        loginRespVo.setRefreshToken("bar");

        CommonResult<LoginRespVo> res = new CommonResult<>(loginRespVo);
        return res.success(loginRespVo);
    }

    @PostMapping apping("/login-req")
    public CommonResult<LoginRespVo> hello(@RequestBody @Valid LoginReqVo reqVo) {
        LoginRespVo loginRespVo = new LoginRespVo();
        loginRespVo.setAccessToken("foo");
        loginRespVo.setRefreshToken("bar");

        CommonResult<LoginRespVo> res = new CommonResult<>(loginRespVo);
        return res.success(loginRespVo);
    }


}
