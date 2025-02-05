package com.mappings.one_one.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mappings.one_one.model.Idcard;
import com.mappings.one_one.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
	Optional<Student> findByIdCard(Idcard idCard);
}
