package com.mappings.many_one.model;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long fid;

    private String facultyname;
    private String designation;

    @ManyToOne
    @JoinColumn(name = "did", referencedColumnName = "did", nullable = false, foreignKey = @ForeignKey(name = "FK_Faculty_Department"))
    private Department department;
}
