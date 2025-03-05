package com.spring.event_management.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.spring.event_management.entities.Event;
import com.spring.event_management.entities.Users;
import com.spring.event_management.repos.EventRepo;
import com.spring.event_management.repos.UsersRepo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepo eventRepo;
    private final UsersRepo usersRepo;

    public Event createEvent(Event event, Long organizerId) {
        Users organizer = usersRepo.findById(organizerId)
                .orElseThrow(() -> new RuntimeException("Organizer not found with ID: " + organizerId));

        if (event.getOrganizers() == null) { 
            event.setOrganizers(new ArrayList<>());  // ✅ Fix: Initialize list if null
        }

        event.getOrganizers().add(organizer);
        return eventRepo.save(event);
    }

    // Assign multiple organizers to an existing event
    public Event assignOrganizers(Long eventId, List<Long> organizerIds) {
        Event event = eventRepo.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        List<Users> organizers = usersRepo.findAllById(organizerIds);
        if (organizers.isEmpty()) {
            throw new RuntimeException("No valid organizers found");
        }

        event.getOrganizers().addAll(organizers);
        return eventRepo.save(event);
    }

    // Get all events
    public List<Event> getAllEvents() {
        return eventRepo.findAll();
    }

    // Get an event by ID
    public Event getEventById(Long id) {
        return eventRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Event with ID " + id + " not found"));
    }
}