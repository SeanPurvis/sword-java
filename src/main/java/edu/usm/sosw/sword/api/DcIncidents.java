package edu.usm.sosw.sword.api;

import java.sql.Date;

public class DcIncidents {
	private int caseid;
	private int id;
	private Date doa;
	private String doa_time;
	private String cell;
	private String booking_officer;
	private String arresting_officer;
	private String arresting_agency;
	private String attorney;
	private String docket;
	private String hold_for;
	private String hold_released_by;
	private Date hold_released_date;
	private String intake_notes;
	private Date releasing_date;
	private String releasing_time;
	private String releasing_officer;
	private String releasing_how;
	private String releasing_authority;
	private String releasing_to;
	private String ordering_county;
	
	public DcIncidents() {
		//Needed for Jackson deserialization
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

	public Date getDoa() {
		return doa;
	}

	public void setDoa(Date doa) {
		this.doa = doa;
	}

	public String getDoa_time() {
		return doa_time;
	}

	public void setDoa_time(String doa_time) {
		this.doa_time = doa_time;
	}

	public String getCell() {
		return cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}

	public String getBooking_officer() {
		return booking_officer;
	}

	public void setBooking_officer(String booking_officer) {
		this.booking_officer = booking_officer;
	}

	public String getArresting_officer() {
		return arresting_officer;
	}

	public void setArresting_officer(String arresting_officer) {
		this.arresting_officer = arresting_officer;
	}

	public String getArresting_agency() {
		return arresting_agency;
	}

	public void setArresting_agency(String arresting_agency) {
		this.arresting_agency = arresting_agency;
	}

	public String getAttorney() {
		return attorney;
	}

	public void setAttorney(String attorney) {
		this.attorney = attorney;
	}

	public String getDocket() {
		return docket;
	}

	public void setDocket(String docket) {
		this.docket = docket;
	}

	public String getHold_for() {
		return hold_for;
	}

	public void setHold_for(String hold_for) {
		this.hold_for = hold_for;
	}

	public String getHold_released_by() {
		return hold_released_by;
	}

	public void setHold_released_by(String hold_released_by) {
		this.hold_released_by = hold_released_by;
	}

	public Date getHold_released_date() {
		return hold_released_date;
	}

	public void setHold_released_date(Date hold_released_date) {
		this.hold_released_date = hold_released_date;
	}

	public String getIntake_notes() {
		return intake_notes;
	}

	public void setIntake_notes(String intake_notes) {
		this.intake_notes = intake_notes;
	}

	public Date getReleasing_date() {
		return releasing_date;
	}

	public void setReleasing_date(Date releasing_date) {
		this.releasing_date = releasing_date;
	}

	public String getReleasing_time() {
		return releasing_time;
	}

	public void setReleasing_time(String releasing_time) {
		this.releasing_time = releasing_time;
	}

	public String getReleasing_officer() {
		return releasing_officer;
	}

	public void setReleasing_officer(String releasing_officer) {
		this.releasing_officer = releasing_officer;
	}

	public String getReleasing_how() {
		return releasing_how;
	}

	public void setReleasing_how(String releasing_how) {
		this.releasing_how = releasing_how;
	}

	public String getReleasing_authority() {
		return releasing_authority;
	}

	public void setReleasing_authority(String releasing_authority) {
		this.releasing_authority = releasing_authority;
	}

	public String getReleasing_to() {
		return releasing_to;
	}

	public void setReleasing_to(String releasing_to) {
		this.releasing_to = releasing_to;
	}

	public String getOrdering_county() {
		return ordering_county;
	}

	public void setOrdering_county(String ordering_county) {
		this.ordering_county = ordering_county;
	}
	
}
