package edu.usm.sosw.sword.api;

import java.math.BigDecimal;
import java.sql.Date;

public class Medications {
	private int id;
	private int youthid;
	private Date request_date;
	private String medication;
	private String frequency;
	private int quantity;
	private String dosage;
	private BigDecimal cost;
	private Date start_date;
	private Date end_date;
	private String ordering_county;
	
	public Medications() {
		//Needed for Jackson deserialization
	}
	
	public Medications(
			int id,
			int youthid,
			Date request_date,
			String medication,
			String frequency,
			int quantity,
			String dosage,
			BigDecimal cost,
			Date start_date,
			Date end_date,
			String ordering_county) {
		super();
		this.id = id;
		this.youthid = youthid;
		this.request_date = request_date;
		this.medication = medication;
		this.frequency = frequency;
		this.quantity = quantity;
		this.dosage = dosage;
		this.cost = cost;
		this.start_date = start_date;
		this.end_date = end_date;
		this.ordering_county = ordering_county;
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

	public Date getRequest_date() {
		return request_date;
	}

	public void setRequest_date(Date request_date) {
		this.request_date = request_date;
	}

	public String getMedication() {
		return medication;
	}

	public void setMedication(String medication) {
		this.medication = medication;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public String getOrdering_county() {
		return ordering_county;
	}

	public void setOrdering_county(String ordering_county) {
		this.ordering_county = ordering_county;
	}
	
	
}
