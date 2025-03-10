package com.spring.event_management.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.spring.event_management.entities.Event;
import com.spring.event_management.entities.Registration;
import com.spring.event_management.entities.Users;
import com.spring.event_management.repos.EventRepo;
import com.spring.event_management.repos.RegistrationRepo;
import com.spring.event_management.repos.UsersRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegistrationService {
    private final RegistrationRepo registrationRepo;
    private final UsersRepo userRepo;
    private final EventRepo eventRepo;

    public List<Users> getAttendeesByEvent(Long id) {
        return registrationRepo.findByEvent_Id(id).stream()
                .filter(reg -> "ATTENDEE".equalsIgnoreCase(reg.getRole())) // Filter only attendees
                .map(Registration::getAttendee)
                .collect(Collectors.toList());
    }

    public Registration registerForEvent(Long userId, Long id, String role) {
        Users attendee = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Event event = eventRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        Registration registration = new Registration();
        registration.setAttendee(attendee);
        registration.setEvent(event);
        registration.setRole(role.toUpperCase());

        return registrationRepo.save(registration);
    }
}
