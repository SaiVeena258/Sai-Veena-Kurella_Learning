package com.spring.event_management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpeakerDTO {
    private Long id;
    private String topic;
    private String username; 
}
