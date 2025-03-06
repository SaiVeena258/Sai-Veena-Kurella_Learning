package com.spring.event_management.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.spring.event_management.entities.Event;
import com.spring.event_management.entities.Users;
import com.spring.event_management.service.EventService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class EventController {
    private final EventService eventService;

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
        return ResponseEntity.ok(eventService.getEventById(id));
    }

    @GetMapping("/{eventId}/organizers")
    public ResponseEntity<List<Users>> getEventOrganizers(@PathVariable Long eventId) {
        return ResponseEntity.ok(eventService.getOrganizersByEventId(eventId));
    }

    @PostMapping(value = "/{organizerId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Event> createEvent(@RequestBody Event event, @PathVariable Long organizerId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(eventService.createEvent(event, organizerId));
    }

    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents() {
        return ResponseEntity.ok(eventService.getAllEvents());
    }

    @PutMapping("/{eventId}/assign-organizers")
    public ResponseEntity<Event> assignOrganizers(@PathVariable Long eventId, @RequestBody List<Long> organizerIds) {
        return ResponseEntity.ok(eventService.assignOrganizers(eventId, organizerIds));
    }
}
