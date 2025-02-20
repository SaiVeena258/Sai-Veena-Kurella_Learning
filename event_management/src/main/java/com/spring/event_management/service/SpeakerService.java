package com.spring.event_management.service;

import org.springframework.stereotype.Service;

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

    public Speaker assignSpeaker(Long speakerId, Long eventId, String topic) {
        Users speaker = usersRepo.findById(speakerId)
                .orElseThrow(() -> new RuntimeException("Speaker not found"));
        Event event = eventRepo.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        Speaker speakerEntry = new Speaker();
        speakerEntry.setSpeaker(speaker);
        speakerEntry.setEvent(event);
        speakerEntry.setTopic(topic);

        return speakerRepo.save(speakerEntry);
    }
}
