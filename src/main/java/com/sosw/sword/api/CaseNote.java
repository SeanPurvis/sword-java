package com.sosw.sword.api;

import java.sql.Date;

public class CaseNote {
	private int id;
	private int youthid;
	private int caseid;
	private int note_id;
	private String note;
	private Date input_date;
	private String input_user;
	
	public CaseNote() {
		//Needed for Jackson deserialization
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

	public int getCaseid() {
		return caseid;
	}

	public void setCaseid(int caseid) {
		this.caseid = caseid;
	}

	public int getNote_id() {
		return note_id;
	}

	public void setNote_id(int note_id) {
		this.note_id = note_id;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
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
	
	
}
