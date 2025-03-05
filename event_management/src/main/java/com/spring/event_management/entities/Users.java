package com.spring.event_management.entities;

import java.util.ArrayList;
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
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String password;
    private String role;

    @ManyToMany(mappedBy = "organizers")
    @JsonIgnore  
    private List<Event> organizedEvents = new ArrayList<>(); // ✅ Fix: Initialize list

    @ManyToMany
    @JoinTable(
        name = "registrations",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "event_id")
    )
    @JsonIgnore 
    private List<Event> registeredEvents = new ArrayList<>(); // ✅ Fix

    @ManyToMany
    @JoinTable(
        name = "speakers",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "event_id")
    )
    @JsonIgnore 
    private List<Event> speakingEvents = new ArrayList<>(); // ✅ Fix
}