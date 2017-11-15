package edu.usm.sosw.sword.api;

public class DosageFrequency {
	private int frequency_id;
	private String frequency;
	
	public DosageFrequency() {
		//Needed for Jackson deserialization
	}

	public int getFrequency_id() {
		return frequency_id;
	}

	public void setFrequency_id(int frequency_id) {
		this.frequency_id = frequency_id;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	
	
}
