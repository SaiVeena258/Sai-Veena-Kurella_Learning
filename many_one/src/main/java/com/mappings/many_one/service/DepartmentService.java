package com.mappings.many_one.service;

import com.mappings.many_one.model.Department;
import com.mappings.many_one.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    public boolean existsByDname(String dname) {
        return departmentRepo.existsByDname(dname);
    }

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
        return departmentRepo.findById(id).map(department -> {
            department.setDname(updatedDepartment.getDname());
            return departmentRepo.save(department);
        }).orElseThrow(() -> new RuntimeException("Department not found with ID: " + id));
    }

    @Transactional
    public void deleteDepartment(Long id) {
        departmentRepo.findById(id).ifPresentOrElse(
            departmentRepo::delete,
            () -> { throw new RuntimeException("Department not found with ID: " + id); }
        );
    }
}
