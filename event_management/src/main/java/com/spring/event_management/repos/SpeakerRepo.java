package com.spring.event_management.repos;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.event_management.entities.Event;
import com.spring.event_management.entities.Speaker;

@Repository
public interface SpeakerRepo extends JpaRepository<Speaker, Long> {
    List<Speaker> findByEvent(Event event);
    List<Speaker> findByEventId(Long eventId);
}
