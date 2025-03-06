package com.spring.event_management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.event_management.entities.Users;
import com.spring.event_management.repos.UsersRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepo usersRepo;

    public Users getUserById(Long id) {
        return usersRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public Users registerUser(Users user) {
        return usersRepo.save(user);
    }

	public List<Users> getAllUsers() {
		return usersRepo.findAll();
	}
}
