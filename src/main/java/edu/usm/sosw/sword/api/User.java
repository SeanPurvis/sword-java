package edu.usm.sosw.sword.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author Sean T. Purvis
 * @version 0.0.1
 * 
 * This class is a representation of the static_users table in Plain Old Java Object form.
 * With the exception of the empty default constructor, every function is auto generated from the expressed
 * private methods.
 * 
 * An object of this class can be consumed and produced by the UserResource end point. 
 * 
 */
public class User {
	private int id;
	private String username;
	private String name;
	private String phone;
	private String password;
	private String employer;
	private String role;
	private String email;
	
	public User() {
		//Needed for Jackson Deserialization
	}

	public User(int id, String username, String name, String phone, String password, String employer, String role,
			String email) {
		super();
		this.id = id;
		this.username = username;
		this.name = name;
		this.phone = phone;
		this.password = password;
		this.employer = employer;
		this.role = role;
		this.email = email;
	}

    @JsonProperty
	public int getId() {
		return id;
	}

    @JsonProperty
	public void setId(int id) {
		this.id = id;
	}

    @JsonProperty
	public String getUsername() {
		return username;
	}

    @JsonProperty
	public void setUsername(String username) {
		this.username = username;
	}

    @JsonProperty
	public String getName() {
		return name;
	}

    @JsonProperty
	public void setName(String name) {
		this.name = name;
	}

    @JsonProperty
	public String getPhone() {
		return phone;
	}

    @JsonProperty
	public void setPhone(String phone) {
		this.phone = phone;
	}

    @JsonProperty
	public String getPassword() {
		return password;
	}

    @JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}

    @JsonProperty
	public String getEmployer() {
		return employer;
	}

    @JsonProperty
	public void setEmployer(String employer) {
		this.employer = employer;
	}

    @JsonProperty
	public String getRole() {
		return role;
	}

    @JsonProperty
	public void setRole(String role) {
		this.role = role;
	}

    @JsonProperty
	public String getEmail() {
		return email;
	}

    @JsonProperty
	public void setEmail(String email) {
		this.email = email;
	}
}



