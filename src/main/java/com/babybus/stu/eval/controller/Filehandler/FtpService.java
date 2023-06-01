package com.babybus.stu.eval.controller.Filehandler;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
public class FtpService {

    private final FtpServerProperties ftpServerProperties;

    @Autowired
    public FtpService(FtpServerProperties ftpServerProperties) {
        this.ftpServerProperties = ftpServerProperties;
    }
    public void createDirectory(String directoryPath) throws IOException {//创建新用户时就应当执行该方法，在远端创建属于其独有的储存文件的文件夹
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(ftpServerProperties.getHost(), ftpServerProperties.getPort());
            ftpClient.login(ftpServerProperties.getUsername(), ftpServerProperties.getPassword());
            ftpClient.makeDirectory(directoryPath);
        } finally {
            ftpClient.logout();
            ftpClient.disconnect();
        }
    }
    public void uploadFileToServer(MultipartFile file) throws IOException {
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(ftpServerProperties.getHost(), ftpServerProperties.getPort());
            ftpClient.login(ftpServerProperties.getUsername(), ftpServerProperties.getPassword());
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
             //视用户情况创建其独有的文件夹
            String fileName = file.getOriginalFilename();
            fileName=new String(fileName.getBytes(StandardCharsets.UTF_8),"iso-8859-1");
            ftpClient.storeFile(fileName, file.getInputStream());
        } finally {
            ftpClient.logout();
            ftpClient.disconnect();
        }
    }
    public void deleteFileFromServer(String filePath) throws IOException {
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(ftpServerProperties.getHost(), ftpServerProperties.getPort());
            ftpClient.login(ftpServerProperties.getUsername(), ftpServerProperties.getPassword());
            filePath=new String(filePath.getBytes(StandardCharsets.UTF_8),"iso-8859-1");
            ftpClient.deleteFile(filePath);
        }
        finally
         {
            ftpClient.logout();
            ftpClient.disconnect();
        }
    }
}

