package com.babybus.yudingyi.controller;



import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.babybus.common.model.CommonResult;
import io.swagger.annotations.Api;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Api(tags = "文件上传处理接口")
@RestController
@RequestMapping("/file")
public class LocalFileController {
    public ResponseEntity<byte[]> downloadFile() throws IOException {
        // Read the file content into a byte array
        File file = new File("/path/to/file.xlsx");
        byte[] fileContent = Files.readAllBytes(file.toPath());

        // Set the response headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", file.getName());

        // Create the ResponseEntity with the file content and headers
        return new ResponseEntity<>(fileContent, headers, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/upload")
    public CommonResult<?> upload(MultipartFile file){
        System.out.println("正在上传文件：" + file.getOriginalFilename());
        byte[] bytes = new byte[20];

        // Get the current working directory
        String currentWorkingDir = System.getProperty("user.dir");
        // Define the relative path to the desired directory
        String relativePath = "src/main/resources/yudingyi/static";
        // Create the absolute path by combining the current working directory and the relative path
        Path absolutePath = Paths.get(currentWorkingDir, relativePath);
        // Convert the absolute path to a string
        String absolutePathString = absolutePath.toString();
        
        //D:\二学位非软件文件\敏捷软件开发\小组项目\stu-eval-backend\src\main\resources\static
        String file_url = absolutePathString + "/" + file.getOriginalFilename();

        try(
                FileOutputStream fos = new FileOutputStream(file_url);
                FileInputStream ips = (FileInputStream)file.getInputStream();)
        {
            int read = ips.read(bytes);
            while(read != -1){
                fos.write(bytes, 0, bytes.length);
                read = ips.read(bytes);
            };
        }catch(Exception e){
            System.out.println(e.getMessage());
            return CommonResult.error(500, "上传出现错误");
        }

        System.out.println("*** 上传完毕 ***");
        String[] data = new String[]{file.getOriginalFilename(), file_url};
        return CommonResult.success(data, "成功上传");
    }
//        String host = "43.142.90.238";
//        int port = 21;
//        String userName = "agile";
//        String password = "7C5NB32x7WM3ZjYD";
//        // ftp
//        FTPClient ftpClient = new FTPClient();
//        // 设置连接使用的字符编码。必须在建立连接之前设置。
//        ftpClient.setControlEncoding("UTF-8");
//        ftpClient.setConnectTimeout(5000);
//
//        try {
//            // 连接服务端
//            ftpClient.connect(host, port);
//            System.out.println("连接服务器" + host + ":" + port);
//
//            // ftp操作可能会返回一些响应信息，可以打印出来看看
//            showServerReply(ftpClient);
//
//            // 尝试连接后，检查响应码以确认成功
//            int replyCode = ftpClient.getReplyCode();
//            if (!FTPReply.isPositiveCompletion(replyCode)) {
//                disconnectQuietly(ftpClient);
//                System.out.println("服务器拒绝连接");
//                return CommonResult.error(500, "服务器拒绝连接");
//            }
//        } catch (IOException e) {
//            disconnectQuietly(ftpClient);
//            System.out.println("连接ftp失败");
//            e.printStackTrace();
//            return CommonResult.error(500, "连接ftp失败");
//        }
//
//        try {
//            // 登录ftp
//            boolean success = ftpClient.login(userName, password);
//            if (!success) {
//                ftpClient.logout();
//                System.out.println("客户端登录失败");
//                return CommonResult.error(500, "客户端登录失败");
//            }
//            System.out.println("客户端登录成功");
//            // 大部分情况，上传文件时，需要设置这两项
//            // 设置文件传输类型为二进制文件类型
//            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
//            // 设置被动模式 1000~3305
//            ftpClient.enterLocalPassiveMode();
//
////            // 设置主动模式 port range 2800-3000，可接受范围1000~3305
////            ftpClient.enterLocalActiveMode();
////            ftpClient.setActivePortRange(2800, 3000);
//
//            boolean done = false;
//            try (InputStream input = file.getInputStream()) {
//                // 设置上传到ftp上使用的文件名和路径
//                String remote = file.getOriginalFilename();
//                // 上传文件
//                done = ftpClient.storeFile(remote, input);
//            }
//            if (done) {
//                System.out.println("上传文件" + file.getOriginalFilename() + "成功");
//                // ftpClient.completePendingCommand();
//            } else {
//                System.out.println("上传文件" + file.getOriginalFilename() + "失败");
//                showServerReply(ftpClient);
//            }
//            ftpClient.noop(); // check that control connection is working OK
//            ftpClient.logout();
//        } catch(FTPConnectionClosedException e) {
//            System.out.println("服务端关闭连接");
//            e.printStackTrace();
//            return CommonResult.error(500, "服务端关闭连接");
//        } catch (IOException e) {
//            System.out.println("客户端登录或操作失败");
//            e.printStackTrace();
//            return CommonResult.error(500, "客户端登录或操作失败");
//        } finally {
//            disconnectQuietly(ftpClient);
//        }
//
//        CommonResult<String> resp = new CommonResult<>("成功上传");
//        return resp.success("成功上传");
//    }
//    /**
//     * 断开ftp连接
//     */
//    @CrossOrigin(origins = "*", allowedHeaders = "*")
//    public static void disconnectQuietly(FTPClient ftpClient) {
//        if (ftpClient.isConnected()) {
//            try {
//                ftpClient.disconnect();
//            } catch (IOException ex) {
//                // do nothing
//            }
//        }
//    }
//    /**
//     * 打印服务器返回信息
//     */
//    @CrossOrigin(origins = "*", allowedHeaders = "*")
//    public static void showServerReply(FTPClient ftpClient) {
//        String[] replies = ftpClient.getReplyStrings();
//        if (replies != null && replies.length > 0) {
//            for (String aReply : replies) {
//                System.out.println("服务端响应信息: " + aReply);
//            }
//        }
//    }

}

