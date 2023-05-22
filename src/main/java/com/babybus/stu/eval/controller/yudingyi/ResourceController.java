package com.babybus.stu.eval.controller.yudingyi;

import lombok.Data;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;

@Data
public class ResourceController {
    private ResourceLoader resourceLoader;
    private String resourcesPath;

    public ResourceController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
        this.resourcesPath = getResourcesDirectory();
    }

    public String getResourcesDirectory() {
        Resource resource = resourceLoader.getResource("classpath:");
        try {
            return resource.getFile().getAbsolutePath();
        } catch (IOException e) {
            // Handle the exception appropriately
            e.printStackTrace();
            return null;
        }
    }
}
