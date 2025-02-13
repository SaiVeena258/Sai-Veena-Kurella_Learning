package com.spring.spring_security.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.spring_security.model.Users;

import jakarta.servlet.http.HttpServletRequest;

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
	
	@GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }


    @PostMapping("/users")
    public Users adduser(@RequestBody Users user) {
        users.add(user);
        return user;
    }
}
