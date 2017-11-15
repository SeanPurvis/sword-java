package edu.usm.sosw.sword.api;

import java.sql.Date;

public class Youth {
	private int id;
	private String ssn;
	private String race;
	private String gender;
	private Date dob;
	private String birthcity;
	private String birthstate;
	private String isadult;
	private String immediate_medical;
	
	public Youth() {
		//This is needed for Jackson deserialization
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getBirthcity() {
		return birthcity;
	}

	public void setBirthcity(String birthcity) {
		this.birthcity = birthcity;
	}

	public String getBirthstate() {
		return birthstate;
	}

	public void setBirthstate(String birthstate) {
		this.birthstate = birthstate;
	}

	public String getIsadult() {
		return isadult;
	}

	public void setIsadult(String isadult) {
		this.isadult = isadult;
	}

	public String getImmediate_medical() {
		return immediate_medical;
	}

	public void setImmediate_medical(String immediate_medical) {
		this.immediate_medical = immediate_medical;
	}
} 
