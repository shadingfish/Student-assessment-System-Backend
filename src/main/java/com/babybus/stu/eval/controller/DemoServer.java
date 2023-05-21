package com.babybus.stu.eval.controller;

import com.babybus.stu.eval.model.common.CommonResult;
import com.babybus.stu.eval.model.common.VO.LoginReqVo;
import com.babybus.stu.eval.model.common.VO.LoginRespVo;
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

    @PostMapping("/login-req")
    public CommonResult<?> hello(@RequestBody @Valid LoginReqVo reqVo) {
        LoginRespVo loginRespVo = new LoginRespVo();
        loginRespVo.setAccessToken("foo");
        loginRespVo.setRefreshToken("bar");

        return CommonResult.success(loginRespVo, "登录成功");
    }
}
