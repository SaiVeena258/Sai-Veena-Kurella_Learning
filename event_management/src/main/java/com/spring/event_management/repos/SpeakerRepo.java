package com.spring.event_management.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.event_management.entities.Event;
import com.spring.event_management.entities.Speaker;
import com.spring.event_management.entities.Users;

@Repository
public interface SpeakerRepo extends JpaRepository<Speaker, Long> {
    List<Speaker> findByEvent(Event event);
    List<Speaker> findByEvent_Id(Long id);
    boolean existsBySpeakerAndEvent(Users speaker, Event event); 
    Optional <Speaker> findById(Long id);
}
