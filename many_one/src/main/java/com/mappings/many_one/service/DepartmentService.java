package com.mappings.many_one.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mappings.many_one.model.Department;
import com.mappings.many_one.model.Faculty;
import com.mappings.many_one.repository.DepartmentRepo;
import com.mappings.many_one.repository.FacultyRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;
    
    @Autowired
    private FacultyRepo facultyRepo;

    public Department createDepartment(Department department) {
        return departmentRepo.save(department);
    }

    public List<Department> getAllDepartments() {
        return departmentRepo.findAll();
    }

    public Department getDepartmentById(Long id) {
        return departmentRepo.findById(id).orElse(null);
    }

    public Department updateDepartment(Long id, Department updatedDepartment) {
        Optional<Department> existingDepartmentOpt = departmentRepo.findById(id);

        if (existingDepartmentOpt.isPresent()) {
            Department existingDepartment = existingDepartmentOpt.get();
            existingDepartment.setDname(updatedDepartment.getDname());

            return departmentRepo.save(existingDepartment);
        } else {
            throw new RuntimeException("Department not found with ID: " + id);
        }
    }

    //@Transactional
    public void deleteDepartment(long id) {
    		log.info("id:{}",id);
        Optional<Department> departmentOptional = departmentRepo.findById(id);

        if (departmentOptional.isPresent()) {
            Department department = departmentOptional.get();

          departmentRepo.deleteById(id);
        } else {
            throw new RuntimeException("Department not found!");
        }
    }


    }
    
