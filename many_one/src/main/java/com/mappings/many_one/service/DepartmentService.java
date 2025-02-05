package com.mappings.many_one.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mappings.many_one.model.Department;
import com.mappings.many_one.repository.DepartmentRepo;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

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

    @Transactional
    public void deleteDepartment(Long id) {
        Optional<Department> departmentOpt = departmentRepo.findById(id);
        
        if (departmentOpt.isPresent()) {
            departmentRepo.delete(departmentOpt.get());
        } else {
            throw new RuntimeException("Department not found with ID: " + id);
        }
    }
}