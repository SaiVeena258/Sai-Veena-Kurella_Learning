package com.spring.event_management.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.event_management.entities.Event;
import com.spring.event_management.entities.Users;

@Repository
public interface EventRepo extends JpaRepository<Event, Long> {
    List<Event> findByOrganizer(Users organizer);
}
