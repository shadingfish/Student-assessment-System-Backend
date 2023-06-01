package com.babybus.stu.eval.controller.Filehandler;

import com.babybus.stu.eval.model.common.CommonResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@Api("文件操作")
public class FileController {

    private final FtpService ftpService;

    @Autowired
    public FileController(FtpService ftpService) {
        this.ftpService = ftpService;
    }

    @PostMapping("/upload")
    public CommonResult<?> handleFileUpload(MultipartFile file) {
        try {
            ftpService.uploadFileToServer(file);
            return CommonResult.success("File uploaded successfully!", "请求成功！");
        } catch (IOException e) {
            e.printStackTrace();
            return CommonResult.error(500,"failed to upload File");
        }
    }
    @DeleteMapping("/{filePath}")
    public CommonResult<?> deleteFile(@PathVariable String filePath) {
        try {
            ftpService.deleteFileFromServer(filePath);
            return CommonResult.success("File deleted successfully!", "请求成功！");
        } catch (IOException e) {
            e.printStackTrace();
            return CommonResult.error(500,"failed to delete file");
        }
    }
}

