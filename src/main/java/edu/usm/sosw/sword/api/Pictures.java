package edu.usm.sosw.sword.api;

import java.sql.Date;

public class Pictures {
	private int id;
	private int youthid;
	private String pic_name;
	private Date pic_Date;
	
	public Pictures() {
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

	public String getPic_name() {
		return pic_name;
	}

	public void setPic_name(String pic_name) {
		this.pic_name = pic_name;
	}

	public Date getPic_Date() {
		return pic_Date;
	}

	public void setPic_Date(Date pic_Date) {
		this.pic_Date = pic_Date;
	}
	
	
}
