package com.mappings.many_one.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;  // Import Jackson annotations
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    @Id
    private long did;
    private String dname;
    
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)// Managed side of the bidirectional relationship, serialize faculty
   // @JsonManagedReference
    private List<Faculty> faculty = new ArrayList<>();
}
