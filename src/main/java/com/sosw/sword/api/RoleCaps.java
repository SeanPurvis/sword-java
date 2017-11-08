package com.sosw.sword.api;

public class RoleCaps {
	private String role;
	private String cap;
	
	public RoleCaps() {
		//Needed for Jackson deserialization
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}
	
	
}
