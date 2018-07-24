package edu.usm.sosw.sword.api;

import java.sql.Blob;
import java.sql.Date;

public class Documents {
	private int chargeid;
	private int id;
	private String doc_name;
	private Blob text;
	private Date order_date;
	
	public Documents() {
		//Needed for Jackson deserialization
	}
	
	public Documents(
			int chargeid,
			int id,
			String doc_name,
			Blob text,
			Date order_date) {
		this.chargeid = chargeid;
		this.id = id;
		this.doc_name = doc_name;
		this.text = text;
		this.order_date = order_date;
	}

	public int getChargeid() {
		return chargeid;
	}

	public void setChargeid(int chargeid) {
		this.chargeid = chargeid;
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
