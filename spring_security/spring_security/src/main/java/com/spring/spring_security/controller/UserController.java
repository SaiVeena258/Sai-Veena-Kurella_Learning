package com.spring.spring_security.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.spring_security.model.Users;

@RestController
public class UserController {

	private List<Users> users=new ArrayList<>(List.of(
			new Users(1,"Sai","sai@2003"),
			new Users(2,"Veena","veena@25")
			));
	
	@GetMapping("/users")
	public List<Users> getUsers(){
		return users;
	}
}
