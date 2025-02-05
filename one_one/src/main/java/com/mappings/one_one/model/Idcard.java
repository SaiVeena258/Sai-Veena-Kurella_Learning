package com.mappings.one_one.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Idcard {
	
	@Id
	private long cardid;
	private String branch;
	private int section;
		
	public Idcard() {
		super();
	}

	public Idcard(long cardid, String branch, int section, Student student) {
        this.cardid = cardid;
        this.branch = branch;
        this.section = section;
    }

    public long getCardid() {
        return cardid;
    }

    public void setCardid(long cardid) {
        this.cardid = cardid;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    @Override
    public String toString() {
        return "Idcard [cardid=" + cardid + ", branch=" + branch + ", section=" + section + "]";
    }
	
	
}
