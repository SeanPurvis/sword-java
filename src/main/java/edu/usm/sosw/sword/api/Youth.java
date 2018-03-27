package edu.usm.sosw.sword.api;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author Sean T. Purvis
 * @version 0.0.1
 * 
 * This class is a representation of the youth table in Plain Old Java Object form.
 * With the exception of the empty default constructor, every function is auto generated from the expressed
 * private methods.
 * 
 * An object of this class can be consumed and produced by the YouthResource end point. 
 * 
 */

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

	public Youth(int id, String ssn, String race, String gender, Date dob, String birthcity, String birthstate,
			String isadult, String immediate_medical) {
		super();
		this.id = id;
		this.ssn = ssn;
		this.race = race;
		this.gender = gender;
		this.dob = dob;
		this.birthcity = birthcity;
		this.birthstate = birthstate;
		this.isadult = isadult;
		this.immediate_medical = immediate_medical;
	}
    @JsonProperty
	public int getId() {
		return id;
	}
    @JsonProperty
	public void setId(int id) {
		this.id = id;
	}
    @JsonProperty
	public String getSsn() {
		return ssn;
	}
    @JsonProperty
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
    @JsonProperty
	public String getRace() {
		return race;
	}
    @JsonProperty
	public void setRace(String race) {
		this.race = race;
	}
    @JsonProperty
	public String getGender() {
		return gender;
	}
    @JsonProperty
	public void setGender(String gender) {
		this.gender = gender;
	}
    @JsonProperty
	public Date getDob() {
		return dob;
	}
    @JsonProperty
	public void setDob(Date dob) {
		this.dob = dob;
	}
    @JsonProperty
	public String getBirthcity() {
		return birthcity;
	}
    @JsonProperty
	public void setBirthcity(String birthcity) {
		this.birthcity = birthcity;
	}
    @JsonProperty
	public String getBirthstate() {
		return birthstate;
	}
    @JsonProperty
	public void setBirthstate(String birthstate) {
		this.birthstate = birthstate;
	}
    @JsonProperty
	public String getIsadult() {
		return isadult;
	}
    @JsonProperty
	public void setIsadult(String isadult) {
		this.isadult = isadult;
	}
    @JsonProperty
	public String getImmediate_medical() {
		return immediate_medical;
	}
    @JsonProperty
	public void setImmediate_medical(String immediate_medical) {
		this.immediate_medical = immediate_medical;
	}
} 
