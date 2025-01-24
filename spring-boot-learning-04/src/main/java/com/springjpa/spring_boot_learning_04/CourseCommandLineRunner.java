package com.springjpa.spring_boot_learning_04;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springjpa.spring_boot_learning_04.springdatajpa.Coursespringjpa;
//import com.springjpa.spring_boot_learning_04.coursejpa.Coursejpa;
import com.springjpa.spring_boot_learning_04.springdatajpa.CourseSpringDataJpaRepo;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//	@Autowired
//	private Coursejdbc repository;
	
//	@Autowired
//	private Coursejpa repository;
	
	@Autowired
	private CourseSpringDataJpaRepo repository;
	
	@Override
	public void run(String... args) throws Exception {
		repository.save(new Coursespringjpa(3,"RaghuRam","CIC"));
		repository.save(new Coursespringjpa(4,"Mohiuddin","IT"));
		repository.save(new Coursespringjpa(5,"Yatin","IOT"));
		repository.deleteById(4l);
		System.out.println(repository.findById(3l));
		System.out.println(repository.findByStuname("Yatin"));
	}
	

}
