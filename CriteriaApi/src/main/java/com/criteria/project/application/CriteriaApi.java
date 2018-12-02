package com.criteria.project.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class CriteriaApi extends SpringBootServletInitializer {
	
	public static void main(String[] args) {
		SpringApplication.run(CriteriaApi.class, args);
	}
}
