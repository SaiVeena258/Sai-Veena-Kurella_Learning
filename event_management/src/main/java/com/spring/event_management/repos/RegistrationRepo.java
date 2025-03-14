package com.spring.event_management.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.event_management.entities.Registration;
import com.spring.event_management.entities.Users;

@Repository
public interface RegistrationRepo extends JpaRepository<Registration, Long> {
    List<Registration> findByAttendee(Users attendee);
    List<Registration> findByEvent_Id(Long eventId);
    
    @Query("SELECT r.attendee.username FROM Registration r WHERE r.event.id = :eventId AND r.role = 'ATTENDEE'")
    List<String> findAttendeeNamesByEventId(@Param("eventId") Long eventId);

}