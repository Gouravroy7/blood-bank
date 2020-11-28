package com.bloodBank.entity;

public class ShowAllSamples {
	
	private int id;
	private String name;
	private String bloodgroups;
	
	public ShowAllSamples(int id, String name, String bloodgroups) {
		super();
		this.id = id;
		this.name = name;
		this.bloodgroups = bloodgroups;
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

	public String getBloodgroups() {
		return bloodgroups;
	}

	public void setBloodgroups(String bloodgroups) {
		this.bloodgroups = bloodgroups;
	}
	
	

}
