package com.bloodBank.entity;

public class Hospital {

	private int id;
	private String name;
	private String location;
	private String password;
	
	
	public Hospital(int id, String name, String location, String password) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.password = password;
	}
	
	


	public Hospital(int id, String password) {
		super();
		this.id = id;
		this.password = password;
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


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
