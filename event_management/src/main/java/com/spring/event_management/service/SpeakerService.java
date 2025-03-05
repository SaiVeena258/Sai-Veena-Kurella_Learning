package com.spring.event_management.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.event_management.entities.Event;
import com.spring.event_management.entities.Speaker;
import com.spring.event_management.entities.Users;
import com.spring.event_management.repos.EventRepo;
import com.spring.event_management.repos.SpeakerRepo;
import com.spring.event_management.repos.UsersRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SpeakerService {
    private final SpeakerRepo speakerRepo;
    private final UsersRepo usersRepo;
    private final EventRepo eventRepo;
    
    public List<Speaker> getSpeakersByEvent(Long id) {
        return speakerRepo.findByEvent_Id(id);
    }

    // Assign a speaker to an event
    @Transactional
    public Speaker assignSpeaker(Long speakerId, Long id, String topic) {
        Users speaker = usersRepo.findById(speakerId)
                .orElseThrow(() -> new RuntimeException("Speaker with ID " + speakerId + " not found"));
        
        Event event = eventRepo.findById(id) // Fix method call
                .orElseThrow(() -> new RuntimeException("Event with eventId " + id + " not found"));

        // Check if the speaker is already assigned to the event
        if (speakerRepo.existsBySpeakerAndEvent(speaker, event)) {
            throw new RuntimeException("Speaker is already assigned to this event.");
        }

        // Create new speaker entry
        Speaker speakerEntry = new Speaker();
        speakerEntry.setSpeaker(speaker);
        speakerEntry.setEvent(event);
        speakerEntry.setTopic(topic);

        return speakerRepo.save(speakerEntry);
    }
}