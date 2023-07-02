package com.babybus.common.controller.FileHandler;

import com.babybus.common.model.CommonResult;
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
    public CommonResult<?> handleFileUpload(@RequestPart("file") MultipartFile file) {
        try {
            ftpService.uploadFileToServer(file);
            return CommonResult.success(file.getName(),"File uploaded successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            return CommonResult.error(500,"failed to upload File");
        }
    }

    @DeleteMapping("/{filePath}")
    public CommonResult<?> deleteFile(@PathVariable String filePath) {
        try {
            ftpService.deleteFileFromServer(filePath);
            return CommonResult.success("","File deleted successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            return CommonResult.error(500,"failed to delete file");
        }
    }
}

