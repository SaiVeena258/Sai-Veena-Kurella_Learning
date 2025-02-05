package com.mappings.many_one.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mappings.many_one.model.Department;

public interface DepartmentRepo extends JpaRepository<Department, Long>{
	
}
