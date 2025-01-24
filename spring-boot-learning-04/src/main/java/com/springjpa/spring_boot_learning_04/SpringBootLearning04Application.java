package com.springjpa.spring_boot_learning_04;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.springjpa.spring_boot_learning_04.springdatajpa")
public class SpringBootLearning04Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLearning04Application.class, args);
	}

}
