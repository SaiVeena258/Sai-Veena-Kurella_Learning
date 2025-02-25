package com.spring.event_management.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.event_management.entities.Users;
import com.spring.event_management.service.UsersService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class UsersController {
    private final UsersService usersService;

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(usersService.getUserById(id));
    }

    @PostMapping("/register")
    public ResponseEntity<Users> register(@RequestBody Users user) {
        return ResponseEntity.ok(usersService.registerUser(user));
    }
}