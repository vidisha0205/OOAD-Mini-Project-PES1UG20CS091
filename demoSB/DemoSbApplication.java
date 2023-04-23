package com.springboot.demo.demoSB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.springboot.demo.demoSB")
@SpringBootApplication
public class DemoSbApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSbApplication.class, args);
	}

}

