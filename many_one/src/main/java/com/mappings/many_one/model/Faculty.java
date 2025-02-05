package com.mappings.many_one.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	
	@ManyToOne
	@JoinColumn(name="did",referencedColumnName = "did")
	private Department department;
}
