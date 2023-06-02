package com.babybus.wuqile.controller;


import com.babybus.common.model.CommonResult;
import com.babybus.wuqile.mapper.StuCompMapper;
import com.babybus.wuqile.model.StuComp;
import io.swagger.annotations.Api;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@Api(tags = "竞赛获奖接口")
@RequestMapping("/stucomp")
public class StuCompController {
    @Autowired
    StuCompMapper stucommapper;

    @PostMapping("/Viewerinsert")
    CommonResult<?> ViewerInsert(@RequestBody StuComp stucom){
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();
        Timestamp sqlDate=new Timestamp(date.getTime());
        stucom.setEvalTime(sqlDate);
        System.out.println(stucom.toString());
        stucommapper.ViewerInsert(stucom);
        return CommonResult.success(stucom,"insert successful");
    }
    @GetMapping("/view")
    CommonResult<?>getAll(){
        List<StuComp> stucom=stucommapper.getAll();
        return CommonResult.success(stucom,"get all results successful");
    }
    @GetMapping("/byid")
    CommonResult<?> getAllByStuID(@Param("stu_id") int stu_id){
        List<StuComp> stucom=stucommapper.getAllByStuID(stu_id);
        return CommonResult.success(stucom,"find it successful: "+stu_id);
    }
    @DeleteMapping("/studelete/{mat_id}")
    CommonResult<?> deleteRec(@PathVariable int mat_id){
        try{
            stucommapper.deleteCom(mat_id);
            return CommonResult.success("","delete success");
        }catch (Exception E){
            return CommonResult.error(500,"delete failed");
        }

    }
    @PostMapping("/stuinsert")
    CommonResult<?> insertRec(@RequestBody StuComp stuComp){
        try{
            stucommapper.insertRecord(stuComp);
            return CommonResult.success("","insert success");
        }
        catch(Exception I){
            return CommonResult.error(500,I.getMessage());
        }
    }
}
