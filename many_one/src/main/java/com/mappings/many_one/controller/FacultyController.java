package com.mappings.many_one.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mappings.many_one.model.Faculty;
import com.mappings.many_one.service.FacultyService;

@RestController
@RequestMapping("/faculty")
@CrossOrigin(origins="http://localhost:3001")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @PostMapping("/addfaculty")
    public ResponseEntity<Faculty> createFaculty(@RequestBody Faculty faculty) {
        Faculty savedFaculty = facultyService.createFaculty(faculty);
        return new ResponseEntity<>(savedFaculty, HttpStatus.CREATED);
    }

    @GetMapping("/displayfaculty")
    public ResponseEntity<List<Faculty>> getAllFaculties() {
        List<Faculty> faculties = facultyService.getAllFaculty();
        return new ResponseEntity<>(faculties, HttpStatus.OK);
    }

    @GetMapping("/displayfaculty/{id}")
    public ResponseEntity<Faculty> getFacultyById(@PathVariable Long id) {
        Faculty faculty = facultyService.getFacultyById(id);
        if (faculty != null) {
            return new ResponseEntity<>(faculty, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updatefaculty/{id}")
    public ResponseEntity<Faculty> updateFaculty(@PathVariable Long id, @RequestBody Faculty updatedFaculty) {
        Faculty faculty = facultyService.updateFaculty(id, updatedFaculty);
        return new ResponseEntity<>(faculty, HttpStatus.OK);
    }

    @DeleteMapping("/deletefaculty/{id}")
    public ResponseEntity<String> deleteFaculty(@PathVariable Long id) {
        try {
            facultyService.deleteById(id);
            return ResponseEntity.ok("Faculty deleted successfully!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting faculty!");
        }
    }
}
