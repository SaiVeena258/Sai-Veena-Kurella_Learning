package com.spring_boot.spring_boot_learning_03;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	
	@RequestMapping("/courses")
	public List<Course> retrieveCourses(){
		return Arrays.asList(
				new Course(1,"SQL","Databases"),
				new Course(2,"ML","Data Processing")
				);
		
	}
}
