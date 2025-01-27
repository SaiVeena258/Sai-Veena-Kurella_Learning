package com.spring.spring_boot_restapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.spring_boot_restapi.entities.Posts;
import com.spring.spring_boot_restapi.repos.Post_repo;

@Service
public class PostService {

	@Autowired
	private Post_repo postRepo;
	
	public List<Posts> displayPost() {
		return postRepo.findAll();
	}
	
	public void userAdd(@RequestBody Posts post) {
		postRepo.save(post);
	}
	
	public void postDelete(@PathVariable int id) {
		postRepo.deleteById((long) id);
	}
	
	public void postUpdate(@PathVariable int id,@RequestBody Posts post) {
		Posts posts=postRepo.findById((long) id).get();
		posts.setDesc(post.getDesc());
		postRepo.save(posts);
	}
}
