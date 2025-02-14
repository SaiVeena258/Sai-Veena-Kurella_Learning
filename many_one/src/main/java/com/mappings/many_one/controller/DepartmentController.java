package com.mappings.many_one.controller;

import com.mappings.many_one.model.Department;
import com.mappings.many_one.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/department")
@CrossOrigin(origins = "http://localhost:3001")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/adddepart")
    public ResponseEntity<String> createDepartment(@RequestBody Department department) {
        if (departmentService.existsByDname(department.getDname())) {
            return ResponseEntity.status(409).body("Department already exists!");
        }
        departmentService.createDepartment(department);
        return ResponseEntity.status(201).body("Department added successfully!");
    }

    @GetMapping("/displaydepart")
    public ResponseEntity<List<Department>> getAllDepartments() {
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @PutMapping("/updatedepart/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @RequestBody Department updatedDepartment) {
        return ResponseEntity.ok(departmentService.updateDepartment(id, updatedDepartment));
    }

    @DeleteMapping("/deletedepart/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
        return ResponseEntity.ok("Department deleted successfully!");
    }
}
