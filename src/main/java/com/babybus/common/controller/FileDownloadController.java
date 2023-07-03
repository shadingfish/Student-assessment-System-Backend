package com.babybus.common.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@CrossOrigin
public class FileDownloadController {
    @Value("${file.upload-path}")
    private String uploadPath;
    @GetMapping("api/downloadFiles/{path}")
    public ResponseEntity<Resource> getFile(@PathVariable String path) {
        try {
            System.out.println(path);
            Path file = Paths.get(uploadPath+ File.separator+path);
            Resource resource = new UrlResource(file.toUri());

            return ResponseEntity.ok()
                    .header("Content-Disposition", "attachment; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);
        } catch (MalformedURLException e) {
            // Handle the error
            e.printStackTrace();
        }

        // Handle the error
        return ResponseEntity.badRequest().build();
    }
}



