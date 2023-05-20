package com.babybus.stu_eval.controller;

import com.alibaba.excel.EasyExcel;
import com.babybus.stu_eval.controller.vo.Demo.RespVo;
import com.babybus.stu_eval.model.CommonResult;
import com.babybus.stu_eval.model.Export.EvalResult;
import com.babybus.stu_eval.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

@Api(tags = "数据库导出处理接口")
@RestController
@RequestMapping("/export")
public class ExportController {
    @Autowired
    private UserService userService;

    //写文件到本地
    /*
        public List<?> exportTable(@RequestParam("table_name") String table_name){
        String fileName = table_name + ".xlsx";
        String sheetName = "成绩汇总";

        try {
            List<EvalResult> eval_results = userService.exportTable(table_name);
            EasyExcel.write(fileName, EvalResult.class)
                    .sheet(sheetName)
                    .doWrite(eval_results);
            System.out.println("成功导出" + fileName);
            System.out.println(eval_results);
            return eval_results;
        } catch (Exception e){
            System.out.println("导出错误：" + e.getMessage());
            ArrayList<String> res = new ArrayList<>();
            res.add("导出错误：" + e.getMessage());
            return res;
        }
    };
     */
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping ("/table")
    //前端下载文件
    public ResponseEntity<byte[]> exportTable(@RequestParam("table_name") String table_name) {
        String fileName = table_name + ".xlsx";
        String sheetName = "成绩汇总";

        try {
            List<EvalResult> eval_results = userService.exportTable(table_name);

            // Create the Excel file in memory
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            EasyExcel.write(outputStream, EvalResult.class)
                    .sheet(sheetName)
                    .doWrite(eval_results);

            // Set the response headers
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", fileName);
            System.out.println("成功导出" + fileName);

            // Return the file content as a response
            return new ResponseEntity<>(outputStream.toByteArray(), headers, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("导出错误：" + e.getMessage());
            // Return an error response if something goes wrong
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
