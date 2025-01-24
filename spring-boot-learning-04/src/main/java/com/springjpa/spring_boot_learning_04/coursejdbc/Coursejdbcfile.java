package com.springjpa.spring_boot_learning_04.coursejdbc;

public class Coursejdbcfile {
	
	private long id;
	
	private String stuname;
	
	private String branch;
	
	public Coursejdbcfile() {
    }
	
	public Coursejdbcfile(long id, String stuname, String branch) {
		super();
		this.id = id;
		this.stuname = stuname;
		this.branch = branch;
	}
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public String getStuname() {
		return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", stuname=" + stuname + ", branch=" + branch + "]";
	}
	
}
