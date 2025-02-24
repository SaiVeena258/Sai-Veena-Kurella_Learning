package com.spring.event_management.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.event_management.entities.Registration;
import com.spring.event_management.entities.Users;

@Repository
public interface RegistrationRepo extends JpaRepository<Registration, Long> {
    List<Registration> findByAttendee(Users attendee);
    List<Registration> findByEventId(Long eventId);

}
