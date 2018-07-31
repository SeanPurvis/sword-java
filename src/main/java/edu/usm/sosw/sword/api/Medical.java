package edu.usm.sosw.sword.api;

public class Medical {
	private int caseid;
	private int id;
	private String immediate_medical_needs;
	private String immediate_phych_needs; //Not a misspelling, table is named this.
	private String current_medications;
	private String medical_insurance;
	private String agency1;
	private String benefits1;
	private String agency2;
	private String benefits2;
	private String agency3;
	private String benefits3;
	
	public Medical() {
		//Needed for Jackson deserialization
	}
	
	public Medical(
			int caseid,
			int id,
			String immediate_medical_needs,
			String immediate_phych_needs,
			String current_medications,
			String medical_insurance,
			String agency1,
			String benefits1,
			String agency2,
			String benefits2,
			String agency3,
			String benefits3) {
		this.caseid = caseid;
		this.id = id;
		this.immediate_medical_needs = immediate_medical_needs;
		this.immediate_phych_needs = immediate_phych_needs;
		this.current_medications = current_medications;
		this.medical_insurance = medical_insurance;
		this.agency1 = agency1;
		this.benefits1 = benefits1;
		this.agency2 = agency2;
		this.benefits2 = benefits2;
		this.agency3 = agency3;
		this.benefits3 = benefits3;
	}

	public int getCaseid() {
		return caseid;
	}

	public void setCaseid(int caseid) {
		this.caseid = caseid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImmediate_medical_needs() {
		return immediate_medical_needs;
	}

	public void setImmediate_medical_needs(String immediate_medical_needs) {
		this.immediate_medical_needs = immediate_medical_needs;
	}

	public String getImmediate_phych_needs() {
		return immediate_phych_needs;
	}

	public void setImmediate_phych_needs(String immediate_phych_needs) {
		this.immediate_phych_needs = immediate_phych_needs;
	}

	public String getCurrent_medications() {
		return current_medications;
	}

	public void setCurrent_medications(String current_medications) {
		this.current_medications = current_medications;
	}

	public String getMedical_insurance() {
		return medical_insurance;
	}

	public void setMedical_insurance(String medical_insurance) {
		this.medical_insurance = medical_insurance;
	}

	public String getAgency1() {
		return agency1;
	}

	public void setAgency1(String agency1) {
		this.agency1 = agency1;
	}

	public String getBenefits1() {
		return benefits1;
	}

	public void setBenefits1(String benefits1) {
		this.benefits1 = benefits1;
	}

	public String getAgency2() {
		return agency2;
	}

	public void setAgency2(String agency2) {
		this.agency2 = agency2;
	}

	public String getBenefits2() {
		return benefits2;
	}

	public void setBenefits2(String benefits2) {
		this.benefits2 = benefits2;
	}

	public String getAgency3() {
		return agency3;
	}

	public void setAgency3(String agency3) {
		this.agency3 = agency3;
	}

	public String getBenefits3() {
		return benefits3;
	}

	public void setBenefits3(String benefits3) {
		this.benefits3 = benefits3;
	}
	
	
}
