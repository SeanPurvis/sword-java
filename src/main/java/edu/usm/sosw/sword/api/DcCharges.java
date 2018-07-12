package edu.usm.sosw.sword.api;

import java.sql.Date;

public class DcCharges {
	private int caseid;
	private int id;
	private String statute;
	private String sqlclass; // Needs to be called class in the table
	private String offense_desc;
	private int book;
	private int page;
	private int line;
	private Date offense_date;
	
	public DcCharges() {
		//Needed for Jackson deserialization
	}
	
	public DcCharges(
			int caseid,
			int id,
			String statute,
			String sqlclass,
			String offense_desc,
			int book,
			int page,
			int line,
			Date offense_date) {
		this.caseid = caseid;
		this.id = id;
		this.statute = statute;
		this.sqlclass = sqlclass;
		this.offense_desc = offense_desc;
		this.book = book;
		this.page = page;
		this.line = line;
		this.offense_date = offense_date;
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

	public String getOffense_desc() {
		return offense_desc;
	}

	public void setOffense_desc(String offense_desc) {
		this.offense_desc = offense_desc;
	}

	public int getBook() {
		return book;
	}

	public void setBook(int book) {
		this.book = book;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public Date getOffense_date() {
		return offense_date;
	}

	public void setOffense_date(Date offense_date) {
		this.offense_date = offense_date;
	}
	
	
	
}