package com.spring.event_management.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.event_management.entities.Speaker;
import com.spring.event_management.service.SpeakerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/speakers")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class SpeakerController {
    private final SpeakerService speakerService;
    
    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<Speaker>> getSpeakersForEvent(@PathVariable Long eventId) {
        List<Speaker> speakers = speakerService.getSpeakersByEvent(eventId);
        return ResponseEntity.ok(speakers);
    }
    
    @PostMapping("/{speakerId}/{eventId}")
    public ResponseEntity<Speaker> assignSpeaker(
            @PathVariable Long speakerId,
            @PathVariable Long eventId,
            @RequestParam String topic) {
        return ResponseEntity.ok(speakerService.assignSpeaker(speakerId, eventId, topic));
    }
}
