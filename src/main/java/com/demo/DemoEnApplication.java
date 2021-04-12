package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.demo.controller.DemoEnController;

@SpringBootApplication
public class DemoEnApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoEnApplication.class, args);
	}

}
