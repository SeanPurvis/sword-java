package edu.usm.sosw.sword.api;

public class Personal {
	private int id;
	private String category;
	private String description;
	
	public Personal() {
		//Needed for Jackson deserialization
	}
	
	public Personal(
			int id,
			String category,
			String description) {
		this.id = id;
		this.category = category;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
