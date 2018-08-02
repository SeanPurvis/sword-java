package edu.usm.sosw.sword.api;

public class Medication {
	private int med_id;
	private String medication;
	private String floor_stock;
	
	public Medication() {
		// Needed by Jackson deserialization
	}
	
	public Medication(
			int med_id,
			String medication,
			String floor_stock) {
		this.med_id = med_id;
		this.medication = medication;
		this.floor_stock = floor_stock;
	}

	public int getMed_id() {
		return med_id;
	}

	public void setMed_id(int med_id) {
		this.med_id = med_id;
	}

	public String getMedication() {
		return medication;
	}

	public void setMedication(String medication) {
		this.medication = medication;
	}

	public String getFloor_stock() {
		return floor_stock;
	}

	public void setFloor_stock(String floor_stock) {
		this.floor_stock = floor_stock;
	}	
}
