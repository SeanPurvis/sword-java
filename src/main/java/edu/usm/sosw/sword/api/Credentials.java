package edu.usm.sosw.sword.api;

import java.io.Serializable;

/**
 * 
 * @author Sean T. Purvis
 * 
 * Credentials exists to facilitate the sending of username and password data from the client
 * to the API in JSON format. 
 */
public class Credentials implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
