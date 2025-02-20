package com.spring.event_management.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String eventname;
    private String description;

    @ManyToOne
    @JoinColumn(name = "organizer_id")
    @JsonBackReference 
    private Users organizer;

    @ManyToMany(mappedBy = "registeredEvents")
    @JsonBackReference
    private List<Users> attendees;

    @ManyToMany(mappedBy = "speakingEvents")
    @JsonBackReference
    private List<Users> speakers;
}

