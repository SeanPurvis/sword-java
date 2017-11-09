package com.sosw.sword.api;

import java.sql.Blob;
import java.sql.Date;

public class DocScanned {
	private int caseid;
	private int id;
	private String doc_name;
	private Blob text;
	private Date order_date;
	
	public DocScanned() {
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

	public String getDoc_name() {
		return doc_name;
	}

	public void setDoc_name(String doc_name) {
		this.doc_name = doc_name;
	}

	public Blob getText() {
		return text;
	}

	public void setText(Blob text) {
		this.text = text;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	
	
}
