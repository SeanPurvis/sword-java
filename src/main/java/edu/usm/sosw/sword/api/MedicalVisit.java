package edu.usm.sosw.sword.api;

import java.sql.Date;

public class MedicalVisit {
	private int medical_visit_id;
	private int youthid;
	private Date visit_date;
	private String medical_staff;
	private String complaint;
	private String diagnosis;
	private String outside_treatment;
	private double outside_treatment_fee;
	private String secondary_outside_treatment;
	private double secondary_outside_treatment_fee;
	private double transport_cost;
	private String ordering_county;
	
	public MedicalVisit() {
		//Needed for Jackson deserialization
	}

	public int getMedical_visit_id() {
		return medical_visit_id;
	}

	public void setMedical_visit_id(int medical_visit_id) {
		this.medical_visit_id = medical_visit_id;
	}

	public int getYouthid() {
		return youthid;
	}

	public void setYouthid(int youthid) {
		this.youthid = youthid;
	}

	public Date getVisit_date() {
		return visit_date;
	}

	public void setVisit_date(Date visit_date) {
		this.visit_date = visit_date;
	}

	public String getMedical_staff() {
		return medical_staff;
	}

	public void setMedical_staff(String medical_staff) {
		this.medical_staff = medical_staff;
	}

	public String getComplaint() {
		return complaint;
	}

	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getOutside_treatment() {
		return outside_treatment;
	}

	public void setOutside_treatment(String outside_treatment) {
		this.outside_treatment = outside_treatment;
	}

	public double getOutside_treatment_fee() {
		return outside_treatment_fee;
	}

	public void setOutside_treatment_fee(double outside_treatment_fee) {
		this.outside_treatment_fee = outside_treatment_fee;
	}

	public String getSecondary_outside_treatment() {
		return secondary_outside_treatment;
	}

	public void setSecondary_outside_treatment(String secondary_outside_treatment) {
		this.secondary_outside_treatment = secondary_outside_treatment;
	}

	public double getSecondary_outside_treatment_fee() {
		return secondary_outside_treatment_fee;
	}

	public void setSecondary_outside_treatment_fee(double secondary_outside_treatment_fee) {
		this.secondary_outside_treatment_fee = secondary_outside_treatment_fee;
	}

	public double getTransport_cost() {
		return transport_cost;
	}

	public void setTransport_cost(double transport_cost) {
		this.transport_cost = transport_cost;
	}

	public String getOrdering_county() {
		return ordering_county;
	}

	public void setOrdering_county(String ordering_county) {
		this.ordering_county = ordering_county;
	}
	
	
}
