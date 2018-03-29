package edu.usm.sosw.sword.api;

/**
 * This class is a representation rows of the <code>counselors</code> table in Plain Old Java Object form.
 * With the exception of the empty default constructor, every function is auto generated from the expressed
 * private methods. An object of this class can be consumed and produced by the <code>CounselorResource</code> end point.
 * @author Sean T. Purvis
 * @version 0.0.1
 * @see CounselorMapper
 * @see CounselorDAO
 * @see CounselorResource
 */
public class Counselor {
	private int id;
	private String name;
	private String email;
	private int status;
	
	public Counselor() {
		//Needed for Jackson deserialization
	}
	
	public Counselor(int id, String name, String email, int status) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.status = status;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
