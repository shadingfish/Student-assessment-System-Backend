package com.babybus;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig {

    @Bean
    public Docket buildDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.babybus.common.controller"))
                .paths(PathSelectors.any())
                .build()
                .groupName("通用 API")
                .apiInfo(apiInfo());
    }

    @Bean
    public Docket wangdy55Api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.babybus.wangdy55.controller"))
                .paths(PathSelectors.any())
                .build()
                .groupName("wangdy55 API")
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Babybus SCE Backend API",
                "学生综测系统后端 API",
                "1.0",
                "Terms of service URL",
                babybusContact(),
                "MIT License",
                "MIT License",
                Collections.emptyList());
    }

    private Contact babybusContact() {
        return new Contact("🚌宝宝巴士", "https://gitee.com/babybus-agile-dev/stu-eval-backend", "wangdy55@qq.com");
    }
}