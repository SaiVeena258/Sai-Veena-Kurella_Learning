package com.mappings.many_one.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mappings.many_one.model.Faculty;
import com.mappings.many_one.model.Department;
import com.mappings.many_one.repository.FacultyRepo;
import com.mappings.many_one.repository.DepartmentRepo;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepo facultyRepo;

    @Autowired
    private DepartmentRepo departmentRepo;

    public Faculty createFaculty(Faculty faculty) {
        Department dept = departmentRepo.findById(faculty.getDepartment().getDid())
                .orElseThrow(() -> new RuntimeException("Department not found"));
        faculty.setDepartment(dept);

        return facultyRepo.save(faculty);
    }

    public List<Faculty> getAllFaculty() {
        return facultyRepo.findAll();
    }

    public Faculty getFacultyById(Long id) {
        return facultyRepo.findById(id).orElse(null);
    }

    public Faculty updateFaculty(Long id, Faculty updatedFaculty) {
        Optional<Faculty> existingFacultyOpt = facultyRepo.findById(id);
        if (existingFacultyOpt.isPresent()) {
            Faculty existingFaculty = existingFacultyOpt.get();
            existingFaculty.setFacultyname(updatedFaculty.getFacultyname());
            existingFaculty.setDesignation(updatedFaculty.getDesignation());
            Department dept = departmentRepo.findById(updatedFaculty.getDepartment().getDid())
                    .orElseThrow(() -> new RuntimeException("Department not found"));
            existingFaculty.setDepartment(dept);
            return facultyRepo.save(existingFaculty);
        } else {
            throw new RuntimeException("Faculty not found with ID: " + id);
        }
    }

    @Transactional
    public void deleteById(Long id) {
        if (!facultyRepo.existsById(id)) {
            throw new RuntimeException("Faculty with ID " + id + " not found!");
        }
        facultyRepo.deleteById(id);
    }
}
