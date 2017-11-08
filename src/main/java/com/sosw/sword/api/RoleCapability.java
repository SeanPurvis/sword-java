package com.sosw.sword.api;

public class RoleCapability {
	private String role;
	private String cap;
	
	public RoleCapability() {
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
