package com.spring.spring_boot_restapi.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.spring_boot_restapi.entities.Posts;
import com.spring.spring_boot_restapi.services.PostService;

@RestController
@RequestMapping("/webapp")
public class PostController {

	@Autowired
	private PostService postService;
	
	@GetMapping("/allposts")
	public List<Posts> postDisplay(){
		return postService.displayPost();
	}
	
	@PostMapping("/insertpost")
	public void insertUser(@RequestBody Posts post) {
		postService.userAdd(post);
	}
	
	@DeleteMapping("/deletepost/{id}")
	public void deleteUser(@PathVariable int id) {
		postService.postDelete(id);
	}
	
	@PutMapping("/updatepost/{id}")
	public void updateUser(@PathVariable int id,@RequestBody Posts post) {
		postService.postUpdate(id, post);
	}
}
