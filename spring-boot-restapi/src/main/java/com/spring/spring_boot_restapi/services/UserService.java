package com.spring.spring_boot_restapi.services;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.spring_boot_restapi.entities.Users;
import com.spring.spring_boot_restapi.repos.User_repo;

@Service
public class UserService {
	
	@Autowired
	private User_repo userRepo;
	
	public List<Users> displayUser() {
		return userRepo.findAll();
	}
	
	public Optional<Users> displayUserById(@PathVariable int id) {
		return userRepo.findById((long)id);
	}
	
	public Users userAdd(@RequestBody Users user) {
		return userRepo.save(user);
	}
	
	public void userDelete(@PathVariable int id) {
		userRepo.deleteById((long) id);
	}
	
	public Optional<Users> userDisplayName(@PathVariable String userName) {
		return userRepo.findByName(userName);
	}
	
	public void userUpdate(@PathVariable int id,@RequestBody Users user) {
		Users users=userRepo.findById((long) id).get();
		users.setName(user.getName());
		users.setDob(user.getDob());
		userRepo.save(users);
	}
}
