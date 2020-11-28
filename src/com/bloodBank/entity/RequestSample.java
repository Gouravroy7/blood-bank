package com.bloodBank.entity;

public class RequestSample {
	
	private int uid; 
	private int hid;
	private String bloodgroup;
	
	public RequestSample(int uid, int hid, String bloodgroup) {
		super();
		this.uid = uid;
		this.hid = hid;
		this.bloodgroup = bloodgroup;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getHid() {
		return hid;
	}

	public void setHid(int hid) {
		this.hid = hid;
	}

	public String getBloodgroup() {
		return bloodgroup;
	}

	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}
	

}
