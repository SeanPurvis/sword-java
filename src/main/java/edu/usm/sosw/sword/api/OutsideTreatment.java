package edu.usm.sosw.sword.api;

public class OutsideTreatment {
	private int outside_treatment_id;
	private String outside_source;
	
	public OutsideTreatment() {
		// Needed for Jackson deserialization
	}
	
	public OutsideTreatment(
			int outside_treatment_id,
			String outside_source) {
	}

	public int getOutside_treatment_id() {
		return outside_treatment_id;
	}

	public void setOutside_treatment_id(int outside_treatment_id) {
		this.outside_treatment_id = outside_treatment_id;
	}

	public String getOutside_source() {
		return outside_source;
	}

	public void setOutside_source(String outside_source) {
		this.outside_source = outside_source;
	}
	
	
}
