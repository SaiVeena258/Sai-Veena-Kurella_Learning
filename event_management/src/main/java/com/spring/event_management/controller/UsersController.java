package com.spring.event_management.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spring.event_management.entities.Users;
import com.spring.event_management.service.UsersService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UsersController {
    private final UsersService usersService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Users> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(usersService.getUserById(id));
    }

    @PostMapping(value = "/register", 
                 consumes = MediaType.APPLICATION_JSON_VALUE, 
                 produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Users> register(@RequestBody Users user) {
        return ResponseEntity.ok(usersService.registerUser(user));
    }
}
