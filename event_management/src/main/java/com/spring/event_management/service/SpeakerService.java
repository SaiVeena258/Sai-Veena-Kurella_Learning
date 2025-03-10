package com.spring.event_management.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.event_management.dto.SpeakerDTO;
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
    
    public List<SpeakerDTO> getSpeakersByEvent(Long id) {
        List<Speaker> speakers = speakerRepo.findByEvent_Id(id);

        return speakers.stream().map(speaker -> 
            new SpeakerDTO(
                speaker.getId(),
                speaker.getTopic(),
                speaker.getSpeaker().getUsername() 
            )
        ).collect(Collectors.toList());
    }
    
    @Transactional
    public SpeakerDTO assignSpeaker(Long speakerId, Long eventId, String topic) {
        Users speaker = usersRepo.findById(speakerId)
                .orElseThrow(() -> new RuntimeException("Speaker with ID " + speakerId + " not found"));
        
        Event event = eventRepo.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event with eventId " + eventId + " not found"));

        if (speakerRepo.existsBySpeakerAndEvent(speaker, event)) {
            throw new RuntimeException("Speaker is already assigned to this event.");
        }
        
        Speaker speakerEntry = new Speaker();
        speakerEntry.setSpeaker(speaker);
        speakerEntry.setEvent(event);
        speakerEntry.setTopic(topic);

        Speaker savedSpeaker = speakerRepo.save(speakerEntry);

        return new SpeakerDTO(
                savedSpeaker.getId(),
                savedSpeaker.getTopic(),
                savedSpeaker.getSpeaker().getUsername()
        );
    }
}
