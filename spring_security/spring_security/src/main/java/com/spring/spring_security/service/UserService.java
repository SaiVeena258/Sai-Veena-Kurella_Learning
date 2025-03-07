package com.spring.spring_security.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.spring_security.model.Users;
import com.spring.spring_security.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo repo;
	
	@Autowired
	private JWTService jwtService;
	
	@Autowired
	AuthenticationManager authManager;
	
	private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
	public Users register(Users user) {
		user.setPassword(encoder.encode(user.getPassword()));
		repo.save(user);
		return user;
	}
	
	public String verify(Users user) {
		Authentication authentication=authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getName(), user.getPassword()));
		if(authentication.isAuthenticated())
			return jwtService.generateToken(user.getName());
		return "Fail";
	}
}
