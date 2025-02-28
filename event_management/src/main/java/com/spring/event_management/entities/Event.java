package com.spring.event_management.entities;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "events")
public class Event {
	
    private String eventname;
    private String description;
    
    @Id
    private Long id;

    @ManyToMany
    @JoinTable(
        name = "event_organizers",
        joinColumns = @JoinColumn(name = "event_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    @JsonIgnore
    private List<Users> organizers;  

    @ManyToMany(mappedBy = "registeredEvents")
    @JsonIgnore 
    private List<Users> attendees;

    @ManyToMany(mappedBy = "speakingEvents")
    @JsonIgnore  
    private List<Users> speakers;

}