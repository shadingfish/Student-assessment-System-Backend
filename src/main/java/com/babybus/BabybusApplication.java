package com.babybus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = {"com.babybus.wangdy55.component"})
public class BabybusApplication {
	public static void main(String[] args) {
		SpringApplication.run(BabybusApplication.class, args);
	}

}
