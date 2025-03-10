package com.spring.event_management.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spring.event_management.entities.Registration;
import com.spring.event_management.entities.Users;
import com.spring.event_management.service.RegistrationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/registrations")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class RegistrationController {
    private final RegistrationService registrationService;

    @GetMapping(value = "/event/{id}/attendees", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Users>> getAttendeesByEvent(@PathVariable Long id) {
        return ResponseEntity.ok(registrationService.getAttendeesByEvent(id));
    }

    @PostMapping(value = "/{id}/{role}/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Registration> registerForEvent(
            @PathVariable Long id, 
            @PathVariable Long userId, 
            @PathVariable String role) {
        return ResponseEntity.ok(registrationService.registerForEvent(userId, id, role));
    }
}
