package com.sosw.sword.api;

import java.sql.Date;

public class Case {
	private String did;
	private int id;
	private int youthid;
	private String lastname;
	private String firstname;
	private String middlename;
	private String suffix;
	private String alias_monikers;
	private String street;
	private String city;
	private String county;
	private String state;
	private String zip;
	private String home_phone;
	private String length_of_residence_in_county;
	private String location_of_residence;
	private int height_feet;
	private int height_inch;
	private	String weight;
	private String eye_color;
	private String hair_color;
	private String scars;
	private String religion;
	private String emp_status;
	private String emp_where;
	private String immediate_needs;
	private String living_arrangements;
	private String school_attended_last;
	private String school_attended_city;
	private String school_attended_state;
	private String school_attended_zip;
	private String current_grade;
	private String special_ed;
	private String school_attendance;
	private String school_placement;
	private int years_school_completed;
	private Date input_date;
	private String input_user;
	private String protection_case;
	private Date modified_date;
	private String cell_phone;
	private String isclosed;
	private String closing_reason;
	private Date closing_date;
	private String disability;
	
	public Case() {
		//Needed for Jackson deserialization
	}

	public String getDid() {
		return did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getYouthid() {
		return youthid;
	}

	public void setYouthid(int youthid) {
		this.youthid = youthid;
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

	public String getAlias_monikers() {
		return alias_monikers;
	}

	public void setAlias_monikers(String alias_monikers) {
		this.alias_monikers = alias_monikers;
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

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
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

	public String getLength_of_residence_in_county() {
		return length_of_residence_in_county;
	}

	public void setLength_of_residence_in_county(String length_of_residence_in_county) {
		this.length_of_residence_in_county = length_of_residence_in_county;
	}

	public String getLocation_of_residence() {
		return location_of_residence;
	}

	public void setLocation_of_residence(String location_of_residence) {
		this.location_of_residence = location_of_residence;
	}

	public int getHeight_feet() {
		return height_feet;
	}

	public void setHeight_feet(int height_feet) {
		this.height_feet = height_feet;
	}

	public int getHeight_inch() {
		return height_inch;
	}

	public void setHeight_inch(int height_inch) {
		this.height_inch = height_inch;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getEye_color() {
		return eye_color;
	}

	public void setEye_color(String eye_color) {
		this.eye_color = eye_color;
	}

	public String getHair_color() {
		return hair_color;
	}

	public void setHair_color(String hair_color) {
		this.hair_color = hair_color;
	}

	public String getScars() {
		return scars;
	}

	public void setScars(String scars) {
		this.scars = scars;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getEmp_status() {
		return emp_status;
	}

	public void setEmp_status(String emp_status) {
		this.emp_status = emp_status;
	}

	public String getEmp_where() {
		return emp_where;
	}

	public void setEmp_where(String emp_where) {
		this.emp_where = emp_where;
	}

	public String getImmediate_needs() {
		return immediate_needs;
	}

	public void setImmediate_needs(String immediate_needs) {
		this.immediate_needs = immediate_needs;
	}

	public String getLiving_arrangements() {
		return living_arrangements;
	}

	public void setLiving_arrangements(String living_arrangements) {
		this.living_arrangements = living_arrangements;
	}

	public String getSchool_attended_last() {
		return school_attended_last;
	}

	public void setSchool_attended_last(String school_attended_last) {
		this.school_attended_last = school_attended_last;
	}

	public String getSchool_attended_city() {
		return school_attended_city;
	}

	public void setSchool_attended_city(String school_attended_city) {
		this.school_attended_city = school_attended_city;
	}

	public String getSchool_attended_state() {
		return school_attended_state;
	}

	public void setSchool_attended_state(String school_attended_state) {
		this.school_attended_state = school_attended_state;
	}

	public String getSchool_attended_zip() {
		return school_attended_zip;
	}

	public void setSchool_attended_zip(String school_attended_zip) {
		this.school_attended_zip = school_attended_zip;
	}

	public String getCurrent_grade() {
		return current_grade;
	}

	public void setCurrent_grade(String current_grade) {
		this.current_grade = current_grade;
	}

	public String getSpecial_ed() {
		return special_ed;
	}

	public void setSpecial_ed(String special_ed) {
		this.special_ed = special_ed;
	}

	public String getSchool_attendance() {
		return school_attendance;
	}

	public void setSchool_attendance(String school_attendance) {
		this.school_attendance = school_attendance;
	}

	public String getSchool_placement() {
		return school_placement;
	}

	public void setSchool_placement(String school_placement) {
		this.school_placement = school_placement;
	}

	public int getYears_school_completed() {
		return years_school_completed;
	}

	public void setYears_school_completed(int years_school_completed) {
		this.years_school_completed = years_school_completed;
	}

	public Date getInput_date() {
		return input_date;
	}

	public void setInput_date(Date input_date) {
		this.input_date = input_date;
	}

	public String getInput_user() {
		return input_user;
	}

	public void setInput_user(String input_user) {
		this.input_user = input_user;
	}

	public String getProtection_case() {
		return protection_case;
	}

	public void setProtection_case(String protection_case) {
		this.protection_case = protection_case;
	}

	public Date getModified_date() {
		return modified_date;
	}

	public void setModified_date(Date modified_date) {
		this.modified_date = modified_date;
	}

	public String getCell_phone() {
		return cell_phone;
	}

	public void setCell_phone(String cell_phone) {
		this.cell_phone = cell_phone;
	}

	public String getIsclosed() {
		return isclosed;
	}

	public void setIsclosed(String isclosed) {
		this.isclosed = isclosed;
	}

	public String getClosing_reason() {
		return closing_reason;
	}

	public void setClosing_reason(String closing_reason) {
		this.closing_reason = closing_reason;
	}

	public Date getClosing_date() {
		return closing_date;
	}

	public void setClosing_date(Date closing_date) {
		this.closing_date = closing_date;
	}

	public String getDisability() {
		return disability;
	}

	public void setDisability(String disability) {
		this.disability = disability;
	}
	
}
