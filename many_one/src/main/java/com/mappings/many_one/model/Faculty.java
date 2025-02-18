package com.mappings.many_one.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Faculty {

    @Id
    private long fid;
    private String facultyname;
    private String designition;
    
    @JsonIgnoreProperties("faculty")
    @ManyToOne
    @JoinColumn(name = "did")
    private Department department;
}
