package edu.usm.sosw.sword.api;

public class MedicalStaff {
	private int med_emp_id;
	private String name;
	private int visitation_fee;
	
	public MedicalStaff() {
		//Needed for Jackson deserialization
	}
	
	public MedicalStaff(
			int med_emp_id,
			String name,
			int visitation_fee) {
		this.med_emp_id = med_emp_id;
		this.name = name;
		this.visitation_fee = visitation_fee;
	}

	public int getMed_emp_id() {
		return med_emp_id;
	}

	public void setMed_emp_id(int med_emp_id) {
		this.med_emp_id = med_emp_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVisitation_fee() {
		return visitation_fee;
	}

	public void setVisitation_fee(int visitation_fee) {
		this.visitation_fee = visitation_fee;
	}
	
	
}
