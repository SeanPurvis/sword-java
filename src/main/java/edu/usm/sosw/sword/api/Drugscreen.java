package edu.usm.sosw.sword.api;

import java.sql.Date;

public class Drugscreen {
	private int youthid;
	private int id;
	private Date testdate;
	private String benzodiazepine;
	private String crystal_methamphetamine;
	private String amphetamines;
	private String thc;
	private String coke;
	private String opiates;
	
	public Drugscreen() {
		//Needed for Jackson deserialization
	}
	
	public Drugscreen(
			int youthid,
			int id,
			Date testdate,
			String benzodiazepine,
			String crystal_methamphetamine,
			String amphetamines,
			String thc,
			String coke,
			String opiates) {
		this.youthid = youthid;
		this.id = id;
		this.testdate = testdate;
		this.benzodiazepine = benzodiazepine;
		this.crystal_methamphetamine = crystal_methamphetamine;
		this.amphetamines = amphetamines;
		this.thc = thc;
		this.coke = coke;
		this.opiates = opiates;
	}

	public int getYouthid() {
		return youthid;
	}

	public void setYouthid(int youthid) {
		this.youthid = youthid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getTestdate() {
		return testdate;
	}

	public void setTestdate(Date testdate) {
		this.testdate = testdate;
	}

	public String getBenzodiazepine() {
		return benzodiazepine;
	}

	public void setBenzodiazepine(String benzodiazepine) {
		this.benzodiazepine = benzodiazepine;
	}

	public String getCrystal_methamphetamine() {
		return crystal_methamphetamine;
	}

	public void setCrystal_methamphetamine(String crystal_methamphetamine) {
		this.crystal_methamphetamine = crystal_methamphetamine;
	}

	public String getAmphetamines() {
		return amphetamines;
	}

	public void setAmphetamines(String amphetamines) {
		this.amphetamines = amphetamines;
	}

	public String getThc() {
		return thc;
	}

	public void setThc(String thc) {
		this.thc = thc;
	}

	public String getCoke() {
		return coke;
	}

	public void setCoke(String coke) {
		this.coke = coke;
	}

	public String getOpiates() {
		return opiates;
	}

	public void setOpiates(String opiates) {
		this.opiates = opiates;
	}
	
	
}
