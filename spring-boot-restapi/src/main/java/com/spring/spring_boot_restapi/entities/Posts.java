package com.spring.spring_boot_restapi.entities;

import jakarta.persistence.Entity;


import jakarta.persistence.Id;

@Entity
public class Posts {
	
	@Id
	private long id;
	private String descrip;
	
	public Posts() {
		super();

	}
	
	public Posts(long id, String descrip) {
		super();
		this.id = id;
		this.descrip = descrip;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getDesc() {
		return descrip;
	}
	
	public void setDesc(String desc) {
		this.descrip = desc;
	}
	
	@Override
	public String toString() {
		return "Posts [id=" + id + ", desc=" + descrip + "]";
	}
	
	

}
