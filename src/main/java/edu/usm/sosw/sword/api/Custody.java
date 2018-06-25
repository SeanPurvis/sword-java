package edu.usm.sosw.sword.api;

import java.sql.Date;

public class Custody {
	private int caseid;
	private int id;
	private Date date_changed;
	private String changed_to;
	
	public Custody() {
		//Needed for Jackson deserialization
	}
  
  public Custody(int caseid, int id, Date date_changed, String changed_to ) {
  this.caseid = caseid;
  this.id = id;
  this.date_changed = date_changed;
  this.changed_to  = changed_to;
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

	public Date getDate_changed() {
		return date_changed;
	}

	public void setDate_changed(Date date_changed) {
		this.date_changed = date_changed;
	}

	public String getChanged_to() {
		return changed_to;
	}

	public void setChanged_to(String changed_to) {
		this.changed_to = changed_to;
	}
	
	
}
