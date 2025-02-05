package com.mappings.many_one.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mappings.many_one.model.Faculty;
import com.mappings.many_one.repository.FacultyRepo;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepo facultyRepo;

    public Faculty createFaculty(Faculty faculty) {
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
            existingFaculty.setDesignition(updatedFaculty.getDesignition());

            return facultyRepo.save(existingFaculty);
        } else {
            throw new RuntimeException("Faculty not found with ID: " + id);
        }
    }

    @Transactional
    public void deleteFaculty(Long id) {
        Optional<Faculty> faculty = facultyRepo.findById(id);
        if (faculty.isPresent()) {
            facultyRepo.delete(faculty.get());
        } else {
            throw new RuntimeException("Faculty not found with ID: " + id);
        }
    }
}