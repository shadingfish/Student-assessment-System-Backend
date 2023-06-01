package com.babybus.wuqile.controller;


import com.babybus.common.model.CommonResult;
import com.babybus.wuqile.mapper.StuSumMapper;
import com.babybus.wuqile.model.StuSum;
import io.swagger.annotations.Api;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "成绩汇总接口")
@RequestMapping("/StuSum")
public class StuSumController {
    @Autowired
    StuSumMapper stusummapper;
    @GetMapping("/getInfo")
    CommonResult<?> getAll(){
        List<StuSum> stusum=stusummapper.getAll();
        if(stusum.equals(null))
            return CommonResult.error(404,"没有找到记录");
        else
            return CommonResult.success(stusum,"");
    }
    @GetMapping("/get")
    CommonResult<?> getByStuID(@Param("stu_id")int stu_id){
        List<StuSum> stusum=stusummapper.getByStuID(stu_id);
        if(stusum.equals(null))
            return CommonResult.error(404,"没有找到记录");
        else
            return CommonResult.success(stusum,"");
    }
}
