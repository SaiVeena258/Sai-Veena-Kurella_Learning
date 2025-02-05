package com.mappings.one_one.model;

import jakarta.persistence.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;


@Entity
public class Student {

	@Id
	private long stuid;
	private String stuname;
	private String stuemail;
	private String phone;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cardid",referencedColumnName = "cardid")
	private Idcard idCard;
	
	public Student() {
		super();
	}
	
	public Student(long stuid, String stuname, String stuemail, String phone) {
		super();
		this.stuid = stuid;
		this.stuname = stuname;
		this.stuemail = stuemail;
		this.phone = phone;
	}

	public long getStuid() {
		return stuid;
	}
	
	public void setStuid(long stuid) {
		this.stuid = stuid;
	}
	
	public String getStuname() {
		return stuname;
	}
	
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	
	public String getStuemail() {
		return stuemail;
	}
	
	public void setStuemail(String stuemail) {
		this.stuemail = stuemail;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public Idcard getIdCard() {
        return idCard;
    }

    public void setIdCard(Idcard idCard) {
        this.idCard = idCard;
    }

	@Override
	public String toString() {
		return "Student [stuid=" + stuid + ", stuname=" + stuname + ", stuemail=" + stuemail + ", phone=" + phone + "]";
	}
	
}
