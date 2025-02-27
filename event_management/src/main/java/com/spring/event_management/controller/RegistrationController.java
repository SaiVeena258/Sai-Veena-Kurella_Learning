package com.spring.event_management.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.event_management.entities.Registration;
import com.spring.event_management.entities.Users;
import com.spring.event_management.service.RegistrationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/registrations")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class RegistrationController {
    private final RegistrationService registrationService;
    
    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<Users>> getAttendeesByEvent(@PathVariable Long eventId) {
        return ResponseEntity.ok(registrationService.getAttendeesByEvent(eventId));
    }

    @PostMapping("/{userId}/{eventId}")
    public ResponseEntity<Registration> registerForEvent(
            @PathVariable Long userId, 
            @PathVariable Long eventId) {
        return ResponseEntity.ok(registrationService.registerForEvent(userId, eventId));
    }
}
