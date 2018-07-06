package edu.usm.sosw.sword.api;

import java.sql.Date;

public class Contact {
	private int id;
	private int caseid;
	private String relationship;
	private String previous_court;
	private String lastname;
	private String firstname;
	private String middlename;
	private String suffix;
	private String is_guardian;
	private String is_same_address;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String home_phone;
	private String cell_phone;
	private String race;
	private String gender;
	private String ssn;
	private Date dob;
	private String marital_status;
	private String education;
	private String occupation;
	private String employer;
	private String work_phone;
	private String receive_assistance;
	private String insurance;
	private String insurance_policy;
	
	public Contact() {
		//Needed for Jackson deserialization
	}
	
	public Contact(
			int id,
			int caseid,
			String relationship,
			String previous_court,
			String lastname,
			String firstname,
			String middlename,
			String suffix,
			String is_guardian,
			String is_same_address,
			String street,
			String city,
			String state,
			String zip,
			String home_phone,
			String cell_phone,
			String race,
			String gender,
			String ssn,
			Date dob,
			String marital_status,
			String education,
			String occupation,
			String employer,
			String work_phone,
			String receive_assistance,
			String insurance,
			String insurance_policy) {
		this. id = id;
		this.caseid = caseid;
		this.relationship = relationship;
		this.previous_court = previous_court;
		this.lastname = lastname;
		this.firstname = firstname;
		this.middlename = middlename;
		this.suffix = suffix;
		this.is_guardian = is_guardian;
		this.is_same_address = is_same_address;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.home_phone = home_phone;
		this.cell_phone = cell_phone;
		this.race = race;
		this.gender = gender;
		this.ssn = ssn;
		this.dob = dob;
		this.marital_status = marital_status;
		this.education = education;
		this.occupation = occupation;
		this.employer = employer;
		this.work_phone = work_phone;
		this.receive_assistance = receive_assistance;
		this.insurance = insurance;
		this.insurance_policy = insurance_policy;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCaseid() {
		return caseid;
	}

	public void setCaseid(int caseid) {
		this.caseid = caseid;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getPrevious_court() {
		return previous_court;
	}

	public void setPrevious_court(String previous_court) {
		this.previous_court = previous_court;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getIs_guardian() {
		return is_guardian;
	}

	public void setIs_guardian(String is_guardian) {
		this.is_guardian = is_guardian;
	}

	public String getIs_same_address() {
		return is_same_address;
	}

	public void setIs_same_address(String is_same_address) {
		this.is_same_address = is_same_address;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getHome_phone() {
		return home_phone;
	}

	public void setHome_phone(String home_phone) {
		this.home_phone = home_phone;
	}

	public String getCell_phone() {
		return cell_phone;
	}

	public void setCell_phone(String cell_phone) {
		this.cell_phone = cell_phone;
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

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getMarital_status() {
		return marital_status;
	}

	public void setMarital_status(String marital_status) {
		this.marital_status = marital_status;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getEmployer() {
		return employer;
	}

	public void setEmployer(String employer) {
		this.employer = employer;
	}

	public String getWork_phone() {
		return work_phone;
	}

	public void setWork_phone(String work_phone) {
		this.work_phone = work_phone;
	}

	public String getReceive_assistance() {
		return receive_assistance;
	}

	public void setReceive_assistance(String receive_assistance) {
		this.receive_assistance = receive_assistance;
	}

	public String getInsurance() {
		return insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	public String getInsurance_policy() {
		return insurance_policy;
	}

	public void setInsurance_policy(String insurance_policy) {
		this.insurance_policy = insurance_policy;
	}
	
	
}
