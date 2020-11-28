package com.bloodBank.entity;

public class Receiver {
	
	private int id;
	private String name;
	private String gender;
	private String bloodgroup;
	private String password;
	
	
	
	public Receiver(int id, String name, String gender, String bloodgroup, String password) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.bloodgroup = bloodgroup;
		this.password = password;
	}
	
	public Receiver(int id, String password) {
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBloodgroup() {
		return bloodgroup;
	}
	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
