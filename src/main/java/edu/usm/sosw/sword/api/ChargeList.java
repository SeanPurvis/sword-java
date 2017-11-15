package edu.usm.sosw.sword.api;

public class ChargeList {
	private int id;
	private String category;
	private String description;
	private String statute;
	private String type; //This field needs to be called class in the static_charge_list table
	private int risk_assessment_value;
	private String petition_name;
	private String petition_child_declaration;
	private String petition_crime_desc_template;
	
	public ChargeList() {
		//Needed for Jackson deserialization
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

	public String getStatute() {
		return statute;
	}

	public void setStatute(String statute) {
		this.statute = statute;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getRisk_assessment_value() {
		return risk_assessment_value;
	}

	public void setRisk_assessment_value(int risk_assessment_value) {
		this.risk_assessment_value = risk_assessment_value;
	}

	public String getPetition_name() {
		return petition_name;
	}

	public void setPetition_name(String petition_name) {
		this.petition_name = petition_name;
	}

	public String getPetition_child_declaration() {
		return petition_child_declaration;
	}

	public void setPetition_child_declaration(String petition_child_declaration) {
		this.petition_child_declaration = petition_child_declaration;
	}

	public String getPetition_crime_desc_template() {
		return petition_crime_desc_template;
	}

	public void setPetition_crime_desc_template(String petition_crime_desc_template) {
		this.petition_crime_desc_template = petition_crime_desc_template;
	}
	
	
}
