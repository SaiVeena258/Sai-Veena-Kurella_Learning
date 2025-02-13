package com.spring.spring_security.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.spring.spring_security.model.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer>{
	Users findByName(String name);
}
