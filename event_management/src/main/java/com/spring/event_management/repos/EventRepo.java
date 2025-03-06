package com.spring.event_management.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.event_management.entities.Event;
import com.spring.event_management.entities.Users;

@Repository
public interface EventRepo extends JpaRepository<Event, Long> {
	List<Event> findByOrganizers(Users user);
    @Query("SELECT e FROM Event e JOIN FETCH e.organizers WHERE e.id = :id")
    Optional<Event> findEventWithOrganizer(@Param("id") Long id);

    Optional<Event> findById(Long id);
}
