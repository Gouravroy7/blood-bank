package com.bloodBank.entity;

public class AddBlood {

	private int id;
	private String bloodgroups;
	
	public AddBlood(int id, String bloodgroups) {
		super();
		this.id = id;
		this.bloodgroups = bloodgroups;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBloodgroups() {
		return bloodgroups;
	}

	public void setBloodgroups(String bloodgroups) {
		this.bloodgroups = bloodgroups;
	}
	
	
	
}
