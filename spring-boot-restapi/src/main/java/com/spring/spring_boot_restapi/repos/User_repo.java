package com.spring.spring_boot_restapi.repos;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.spring_boot_restapi.entities.Users;

public interface User_repo extends JpaRepository<Users, Long> {
	
	@Query(value = "SELECT * FROM Users WHERE name = :userName", nativeQuery = true)
    Optional<Users> findByName( String userName);
}