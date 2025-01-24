package com.springjpa.spring_boot_learning_04.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface CourseSpringDataJpaRepo extends JpaRepository<Coursespringjpa, Long> {
	List<Coursespringjpa> findByStuname(String stuname);
}
