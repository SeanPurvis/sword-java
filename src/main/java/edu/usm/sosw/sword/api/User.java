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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((employer == null) ? 0 : employer.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (employer == null) {
			if (other.employer != null)
				return false;
		} else if (!employer.equals(other.employer))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", name=" + name + ", phone=" + phone + ", password="
				+ password + ", employer=" + employer + ", role=" + role + ", email=" + email + "]";
	}
}



