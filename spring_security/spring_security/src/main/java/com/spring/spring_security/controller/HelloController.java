package com.spring.spring_security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/hello")
	public String hello() {
		return "Hello!!";
	}
	
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/user")
	public String userEndpoint() {
		return "Hello User!!";
	}
	
	@PreAuthorize("hasRole('SAIVEENA')")
	@GetMapping("/name")
	public String nameEndpoint() {
		return "Hello Sai Veena!!";
	}
}
