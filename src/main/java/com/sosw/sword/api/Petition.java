package com.sosw.sword.api;

import java.sql.Date;

public class Petition {
	private int id;
	private int chargeid;
	private String child_name;
	private String docket_num;
	private Date dob;
	private String age;
	private String sex;
	private String address;
	private String pet_title;
	private String father_name;
	private String father_address;
	private String mother_name;
	private String mother_address;
	private String charge_info1;
	private String charge_info2;
	private Date pet_date;
	
	public Petition() {
		//Needed for Jackson deserialization
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getChargeid() {
		return chargeid;
	}

	public void setChargeid(int chargeid) {
		this.chargeid = chargeid;
	}

	public String getChild_name() {
		return child_name;
	}

	public void setChild_name(String child_name) {
		this.child_name = child_name;
	}

	public String getDocket_num() {
		return docket_num;
	}

	public void setDocket_num(String docket_num) {
		this.docket_num = docket_num;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPet_title() {
		return pet_title;
	}

	public void setPet_title(String pet_title) {
		this.pet_title = pet_title;
	}

	public String getFather_name() {
		return father_name;
	}

	public void setFather_name(String father_name) {
		this.father_name = father_name;
	}

	public String getFather_address() {
		return father_address;
	}

	public void setFather_address(String father_address) {
		this.father_address = father_address;
	}

	public String getMother_name() {
		return mother_name;
	}

	public void setMother_name(String mother_name) {
		this.mother_name = mother_name;
	}

	public String getMother_address() {
		return mother_address;
	}

	public void setMother_address(String mother_address) {
		this.mother_address = mother_address;
	}

	public String getCharge_info1() {
		return charge_info1;
	}

	public void setCharge_info1(String charge_info1) {
		this.charge_info1 = charge_info1;
	}

	public String getCharge_info2() {
		return charge_info2;
	}

	public void setCharge_info2(String charge_info2) {
		this.charge_info2 = charge_info2;
	}

	public Date getPet_date() {
		return pet_date;
	}

	public void setPet_date(Date pet_date) {
		this.pet_date = pet_date;
	}
	
	
}
