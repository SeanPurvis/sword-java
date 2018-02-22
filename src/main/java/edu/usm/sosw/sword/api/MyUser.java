package edu.usm.sosw.sword.api;

import java.math.BigDecimal;
import java.security.Principal;

import org.mindrot.jbcrypt.BCrypt;

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

public class MyUser implements Principal {

    private BigDecimal id;
    private String username;
    private String name;
	private String phone;
	private String password;
	private String employer;
	private String role;
	private String email;
	
	public MyUser() {
		//Needed for Jackson Deserialization
	}
	
	public MyUser(BigDecimal id, String name) {
		this.id = id;
		this.name = name;
	}
	
    public MyUser(BigDecimal id, String username, String name, String phone, String password, String employer,
			String role, String email) {
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



	public BigDecimal getId() {
		return id;
	}



	public void setId(BigDecimal id) {
		this.id = id;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getEmployer() {
		return employer;
	}



	public void setEmployer(String employer) {
		this.employer = employer;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	/**
     * This method is used to generate a string representing an account password
     * suitable for database storage. It will be OpenBSD style crypt formatted
     * hash string of length=60
     * The bcrypt workload is specified in the final variable below.
     * @param password_plaintext the user's plaintext password provided when
     * creating the new account or logging in.
     * @return String - a string of length 60 that is the bcrypt hashed password in crypt(3) format.
     */
    public String hashPassword(String password_plaintext) {
    	final int workload = 4;
    	String salt = BCrypt.gensalt(workload);
    	String hashed_password = BCrypt.hashpw(password_plaintext, salt);
    	
    	return(hashed_password);
    }
    
    /**
     * This method will verify a computed hash from a plaintext with that of the hash stored in the database. 
     * @param password_plaintext The user's plaintext password as provided during the login request.
     * @param stored_hash The account's stored password from the database. 
     * @return boolean - true if the password matches the password of the stored hash, false otherwise. 
     */
    public boolean checkPassword(String password_plaintext, String stored_hash) {
    	boolean password_verified = false;
    	
    	if(null == stored_hash || !stored_hash.startsWith("$2a$"))
    		throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");
    	
    	password_verified = BCrypt.checkpw(password_plaintext, stored_hash);
    	
    	return(password_verified);
    }
}