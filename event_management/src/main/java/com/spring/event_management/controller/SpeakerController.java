package com.spring.event_management.controller;

import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spring.event_management.dto.SpeakerDTO;
import com.spring.event_management.service.SpeakerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/speakers")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class SpeakerController {
    private final SpeakerService speakerService;

    @GetMapping(value = "/event/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SpeakerDTO>> getSpeakersForEvent(@PathVariable Long id) {
        return ResponseEntity.ok(speakerService.getSpeakersByEvent(id));
    }
    
    @PostMapping(value = "/{speakerId}/{eventId}", 
                 consumes = MediaType.APPLICATION_JSON_VALUE, 
                 produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SpeakerDTO> assignSpeaker(
            @PathVariable Long speakerId,
            @PathVariable Long eventId,
            @RequestBody SpeakerRequest speakerRequest) { 
        return ResponseEntity.ok(speakerService.assignSpeaker(speakerId, eventId, speakerRequest.getTopic()));
    }

    public static class SpeakerRequest {
        private String topic;
        
        public String getTopic() {
            return topic;
        }

        public void setTopic(String topic) {
            this.topic = topic;
        }
    }
}