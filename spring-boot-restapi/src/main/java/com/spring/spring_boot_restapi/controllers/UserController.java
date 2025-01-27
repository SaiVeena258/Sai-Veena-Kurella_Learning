package com.spring.spring_boot_restapi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.spring_boot_restapi.entities.Users;
import com.spring.spring_boot_restapi.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/allusers")
	public List<Users> userDisplay(){
		return userService.displayUser();
	}
	
	@GetMapping("/allusers/{id}")
	public Optional<Users> userDisplayById(@PathVariable int id){
		return userService.displayUserById(id);
	}
	
	@PostMapping("/insertuser")
	public Users insertUser(@RequestBody Users user) {
		return userService.userAdd(user);
	}
	
	@DeleteMapping("/deleteuser/{id}")
	public void deleteUser(@PathVariable int id) {
		userService.userDelete(id);
	}
	
	@PutMapping("/updateuser/{id}")
	public void updateUser(@PathVariable int id,@RequestBody Users user) {
		userService.userUpdate(id, user);
	}
	
	@GetMapping("/user/{name}")
	public Optional<Users> userDisplayName(@PathVariable String name){
		return userService.userDisplayName(name);
	}
	
	
}
