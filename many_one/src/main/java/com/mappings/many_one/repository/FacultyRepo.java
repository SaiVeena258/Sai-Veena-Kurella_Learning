package com.mappings.many_one.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mappings.many_one.model.Faculty;

public interface FacultyRepo extends JpaRepository<Faculty, Long> {
}
