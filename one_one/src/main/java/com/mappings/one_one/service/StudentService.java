package com.mappings.one_one.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mappings.one_one.model.Student;
import com.mappings.one_one.repository.IdcardRepository;
import com.mappings.one_one.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository stuRepo;
	
	@Autowired
	private IdcardRepository idRepo;
	
	public Student createStu(Student stu) {
        return stuRepo.save(stu);
    }
 
    public List<Student> getAllStudents() {
        return stuRepo.findAll();
    }

    public Student getStudentById(Long id) {
        return stuRepo.findById(id).orElse(null);
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        Optional<Student> existingStudentOpt = stuRepo.findById(id);

        if (existingStudentOpt.isPresent()) {
            Student existingStudent = existingStudentOpt.get();
            existingStudent.setStuname(updatedStudent.getStuname());
            existingStudent.setStuemail(updatedStudent.getStuemail());
            existingStudent.setPhone(updatedStudent.getPhone());

            if (updatedStudent.getIdCard() != null) {
                existingStudent.setIdCard(updatedStudent.getIdCard());
            }

            return stuRepo.save(existingStudent);
        } else {
            throw new RuntimeException("Student not found with ID: " + id);
        }
    }

    @Transactional
    public void deleteStudent(Long id) {
        Optional<Student> stud = stuRepo.findById(id);
        if (stud.isPresent()) {
            Student stu = stud.get();

            if (stu.getIdCard() != null) {
                idRepo.delete(stu.getIdCard());  
                stu.setIdCard(null);
            }

            stuRepo.delete(stu);
        } else {
            throw new RuntimeException("Student not found with ID: " + id);
        }
    }
}
