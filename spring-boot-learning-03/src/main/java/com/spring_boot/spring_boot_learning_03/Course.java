package com.spring_boot.spring_boot_learning_03;

public class Course {
	
	private int id;
	private String name;
	private String field;
	
	
	public Course(int id, String name, String field) {
		super();
		this.id = id;
		this.name = name;
		this.field = field;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getField() {
		return field;
	}


	public void setField(String field) {
		this.field = field;
	}


	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", field=" + field + "]";
	}
	
	
	
	
}
