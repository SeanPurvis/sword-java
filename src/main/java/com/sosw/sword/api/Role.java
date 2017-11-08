package com.sosw.sword.api;

public class Role {
	private int id;
	private String role;
	private String did;
	
	public Role() {
		//Needed for Jackson deserialization
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDid() {
		return did;
	}

	public void setDid(String did) {
		this.did = did;
	}	
}
