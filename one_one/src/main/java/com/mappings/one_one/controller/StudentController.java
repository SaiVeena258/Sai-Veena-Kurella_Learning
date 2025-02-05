package com.mappings.one_one.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mappings.one_one.model.Student;
import com.mappings.one_one.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService stuService;
	
	@PostMapping("/addstu")
	public Student createStu(@RequestBody Student stu) {
        return stuService.createStu(stu);
    }
	
	@GetMapping("/displaystu")
	public List<Student> getAllStudents() {
        return stuService.getAllStudents();
    }
	
	@GetMapping("/displaystu/{id}")
	public Student getStudentById(@PathVariable Long id) {
        return stuService.getStudentById(id);
    }
	
    @PutMapping("/updatestu/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
        Student updatedStu = stuService.updateStudent(id, updatedStudent);
        return ResponseEntity.ok(updatedStu);
    }

	@DeleteMapping("/deletestu/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
		try {
			stuService.deleteStudent(id);
	        return ResponseEntity.ok("Student and associated IdCard deleted successfully!");
		} catch(RuntimeException e) {
			return ResponseEntity.status(404).body(e.getMessage());
		}
    }
}
