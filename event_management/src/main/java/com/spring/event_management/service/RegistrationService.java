package com.spring.event_management.service;

import java.util.List;

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
    
    public List<Users> getAttendeesByEvent(Long eventId) {
        return registrationRepo.findByEventId(eventId)
                .stream()
                .map(Registration::getAttendee)
                .toList();
    }

    public Registration registerForEvent(Long userId, Long eventId) {
        Users attendee = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Event event = eventRepo.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        Registration registration = new Registration();
        registration.setAttendee(attendee);
        registration.setEvent(event);

        return registrationRepo.save(registration);
    }
}
