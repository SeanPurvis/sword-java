package edu.usm.sosw.sword.api;

import java.sql.Date;

public class Charge {
	private int caseid;
	private int id;
	private String docket_number;
	private String statute;
	private String sqlclass; //needs to be called class in the table
	private int risk_assessment_value;
	private String offense_desc;
	private String date_offense_occured;
	private int docket_year;
	private int docket_intake;
	private Date input_date;
	
	public Charge() {
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

	public String getDocket_number() {
		return docket_number;
	}

	public void setDocket_number(String docket_number) {
		this.docket_number = docket_number;
	}

	public String getStatute() {
		return statute;
	}

	public void setStatute(String statute) {
		this.statute = statute;
	}

	public String getSqlclass() {
		return sqlclass;
	}

	public void setSqlclass(String sqlclass) {
		this.sqlclass = sqlclass;
	}

	public int getRisk_assessment_value() {
		return risk_assessment_value;
	}

	public void setRisk_assessment_value(int risk_assessment_value) {
		this.risk_assessment_value = risk_assessment_value;
	}

	public String getOffense_desc() {
		return offense_desc;
	}

	public void setOffense_desc(String offense_desc) {
		this.offense_desc = offense_desc;
	}

	public String getDate_offense_occured() {
		return date_offense_occured;
	}

	public void setDate_offense_occured(String date_offense_occured) {
		this.date_offense_occured = date_offense_occured;
	}

	public int getDocket_year() {
		return docket_year;
	}

	public void setDocket_year(int docket_year) {
		this.docket_year = docket_year;
	}

	public int getDocket_intake() {
		return docket_intake;
	}

	public void setDocket_intake(int docket_intake) {
		this.docket_intake = docket_intake;
	}

	public Date getInput_date() {
		return input_date;
	}

	public void setInput_date(Date input_date) {
		this.input_date = input_date;
	}
	
	
}
