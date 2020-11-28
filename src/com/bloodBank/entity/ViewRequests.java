package com.bloodBank.entity;

public class ViewRequests {
	
	int rid;
	String rname;
	String bloodgroup;
	
	public ViewRequests(int rid, String rname, String bloodgroup) {
		super();
		this.rid = rid;
		this.rname = rname;
		this.bloodgroup = bloodgroup;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getBloodgroup() {
		return bloodgroup;
	}

	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}

	
	
}
