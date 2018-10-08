package com.cg.fmanage.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(scanBasePackages= {"com.cg.fmanage"})
@EntityScan(basePackages="com.cg.fmanage.beans")
@EnableJpaRepositories(basePackages="com.cg.fmanage.repo")
@EnableWebMvc
public class FacultyManagementApplication {
	public static void main(String[] args) {
		SpringApplication.run(FacultyManagementApplication.class, args);
	}
}
