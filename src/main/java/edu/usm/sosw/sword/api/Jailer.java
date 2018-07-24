package edu.usm.sosw.sword.api;

public class Jailer {
	private int id;
	private String code;
	private String name;
	private int status;
	
	public Jailer() {
		//Needed for Jackson deserialization
	}
	
	public Jailer(
			int id,
			String code,
			String name,
			int status) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
