package com.spring.event_management.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.spring.event_management.entities.Event;
import com.spring.event_management.entities.Users;
import com.spring.event_management.repos.EventRepo;
import com.spring.event_management.repos.UsersRepo;
import com.spring.event_management.repos.RegistrationRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepo eventRepo;
    private final UsersRepo usersRepo;
    private final RegistrationRepo registrationRepo;

    public Event createEvent(Event event, Long organizerId) {
        Users organizer = usersRepo.findById(organizerId)
                .orElseThrow(() -> new RuntimeException("Organizer not found"));
        event.getOrganizers().add(organizer);
        return eventRepo.save(event);
    }

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

    public List<Event> getAllEvents() {
        return eventRepo.findAll();
    }

    public Event getEventById(Long id) {
        return eventRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Event with ID " + id + " not found"));
    }

    public List<Users> getOrganizersByEventId(Long eventId) {
        return eventRepo.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"))
                .getOrganizers();
    }

    public List<Users> getAttendeesByEventId(Long eventId) {
        return registrationRepo.findByEvent_Id(eventId).stream()
                .map(registration -> registration.getAttendee())
                .collect(Collectors.toList());
    }

    public List<String> getAttendeeNamesByEventId(Long eventId) {
        return registrationRepo.findAttendeeNamesByEventId(eventId);
    }
}