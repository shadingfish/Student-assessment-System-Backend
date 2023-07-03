package com.babybus.yudingyi.controller;

import com.alibaba.excel.EasyExcel;
import com.babybus.yudingyi.service.ExportService;
import com.babybus.yudingyi.model.DTO.Export.AllEvalView;
import com.babybus.yudingyi.model.DTO.Export.ExportEvalResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URLEncoder;
import java.util.List;

@Api(tags = "数据库导出处理接口")
@RestController
@RequestMapping("/export")
public class ExportController {
    @Autowired
    private ExportService exportService;

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
    @CrossOrigin
    @GetMapping ("/table")
    //前端下载文件
    public ResponseEntity<byte[]> exportTable(@RequestParam("table_name") String table_name) {
        String fileName = table_name + ".xlsx";
        String sheetName = "成绩汇总";

        try {
            List<ExportEvalResult> eval_results = exportService.exportTable(table_name);
            System.out.println(eval_results);

//            // 保存文件到本地的路径和文件名
//            File outputFile = new File(fileName);
//            FileOutputStream fos = new FileOutputStream(outputFile);
//
//
//            // Write the Excel data to the file
//            EasyExcel.write(fos, ExportEvalResult.class)
//                    .sheet(sheetName)
//                    .doWrite(eval_results);
//
//            System.out.println("成功导出到本地" + fileName);

            // Create the Excel file in memory
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            EasyExcel.write(outputStream, ExportEvalResult.class)
                    .sheet(sheetName)
                    .doWrite(eval_results);

            // Set the response headers
            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
//            headers.setContentDispositionFormData("attachment", fileName);
            headers.setContentDispositionFormData("attachment", URLEncoder.encode(fileName, "UTF-8"));
            headers.set(HttpHeaders.CONTENT_ENCODING, "UTF-8");

            System.out.println("成功导出到前端" + fileName);

            // Return the file content as a response
            return new ResponseEntity<>(outputStream.toByteArray(), headers, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("导出错误：" + e.getMessage());
            // Return an error response if something goes wrong
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @CrossOrigin
    @GetMapping ("/view")
    public List<AllEvalView> exportView(){
        List<AllEvalView> list = exportService.exportView();
        System.out.println(list);
        return list;
    }
}
