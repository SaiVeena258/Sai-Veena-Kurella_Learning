package com.spring.event_management.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.event_management.entities.Users;

@Repository
public interface UsersRepo extends JpaRepository<Users, Long> {
    Optional<Users> findByEmail(String email);
}
