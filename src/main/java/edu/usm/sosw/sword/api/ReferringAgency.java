package edu.usm.sosw.sword.api;

public class ReferringAgency {
	private int id;
	private String category;
	private String agency_name;
	
	public ReferringAgency() {
		//Needed for Jackson deserialization
	}

	public ReferringAgency(int id, String category, String agency_name) {
		super();
		this.id = id;
		this.category = category;
		this.agency_name = agency_name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAgency_name() {
		return agency_name;
	}

	public void setAgency_name(String agency_name) {
		this.agency_name = agency_name;
	}
	
	
}
