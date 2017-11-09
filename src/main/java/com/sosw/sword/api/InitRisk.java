package com.sosw.sword.api;

public class InitRisk {
	private int id;
	private int caseid;
	private String name;
	private String dob;
	private int age;
	private String gender;
	private String race;
	private String crime_class;
	private int crime_class_score;
	private String child_hist;
	private int child_hist_score;
	private String vict_impact;
	private int vict_impact_score;
	private String P_C_availability;
	private int P_C_avail_score;
	private String P_C_explain;
	private String other_factors_child;
	private int other_factors_child_score;
	private String other_factors_parent;
	private int other_factors_parent_score;
	private String child_RA_age;
	private int child_RA_age_score;
	private int RA_total_score;
	private String RA_reccomended_action;
	private String Override;
	private String Override_reason;
	private String RA_date;
	private String RA_time;
	private String RA_agency_name;
	private String RA_screener;
	
	public InitRisk() {
		//Needed for Jackson deserialization
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCaseid() {
		return caseid;
	}

	public void setCaseid(int caseid) {
		this.caseid = caseid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getCrime_class() {
		return crime_class;
	}

	public void setCrime_class(String crime_class) {
		this.crime_class = crime_class;
	}

	public int getCrime_class_score() {
		return crime_class_score;
	}

	public void setCrime_class_score(int crime_class_score) {
		this.crime_class_score = crime_class_score;
	}

	public String getChild_hist() {
		return child_hist;
	}

	public void setChild_hist(String child_hist) {
		this.child_hist = child_hist;
	}

	public int getChild_hist_score() {
		return child_hist_score;
	}

	public void setChild_hist_score(int child_hist_score) {
		this.child_hist_score = child_hist_score;
	}

	public String getVict_impact() {
		return vict_impact;
	}

	public void setVict_impact(String vict_impact) {
		this.vict_impact = vict_impact;
	}

	public int getVict_impact_score() {
		return vict_impact_score;
	}

	public void setVict_impact_score(int vict_impact_score) {
		this.vict_impact_score = vict_impact_score;
	}

	public String getP_C_availability() {
		return P_C_availability;
	}

	public void setP_C_availability(String p_C_availability) {
		P_C_availability = p_C_availability;
	}

	public int getP_C_avail_score() {
		return P_C_avail_score;
	}

	public void setP_C_avail_score(int p_C_avail_score) {
		P_C_avail_score = p_C_avail_score;
	}

	public String getP_C_explain() {
		return P_C_explain;
	}

	public void setP_C_explain(String p_C_explain) {
		P_C_explain = p_C_explain;
	}

	public String getOther_factors_child() {
		return other_factors_child;
	}

	public void setOther_factors_child(String other_factors_child) {
		this.other_factors_child = other_factors_child;
	}

	public int getOther_factors_child_score() {
		return other_factors_child_score;
	}

	public void setOther_factors_child_score(int other_factors_child_score) {
		this.other_factors_child_score = other_factors_child_score;
	}

	public String getOther_factors_parent() {
		return other_factors_parent;
	}

	public void setOther_factors_parent(String other_factors_parent) {
		this.other_factors_parent = other_factors_parent;
	}

	public int getOther_factors_parent_score() {
		return other_factors_parent_score;
	}

	public void setOther_factors_parent_score(int other_factors_parent_score) {
		this.other_factors_parent_score = other_factors_parent_score;
	}

	public String getChild_RA_age() {
		return child_RA_age;
	}

	public void setChild_RA_age(String child_RA_age) {
		this.child_RA_age = child_RA_age;
	}

	public int getChild_RA_age_score() {
		return child_RA_age_score;
	}

	public void setChild_RA_age_score(int child_RA_age_score) {
		this.child_RA_age_score = child_RA_age_score;
	}

	public int getRA_total_score() {
		return RA_total_score;
	}

	public void setRA_total_score(int rA_total_score) {
		RA_total_score = rA_total_score;
	}

	public String getRA_reccomended_action() {
		return RA_reccomended_action;
	}

	public void setRA_reccomended_action(String rA_reccomended_action) {
		RA_reccomended_action = rA_reccomended_action;
	}

	public String getOverride() {
		return Override;
	}

	public void setOverride(String override) {
		Override = override;
	}

	public String getOverride_reason() {
		return Override_reason;
	}

	public void setOverride_reason(String override_reason) {
		Override_reason = override_reason;
	}

	public String getRA_date() {
		return RA_date;
	}

	public void setRA_date(String rA_date) {
		RA_date = rA_date;
	}

	public String getRA_time() {
		return RA_time;
	}

	public void setRA_time(String rA_time) {
		RA_time = rA_time;
	}

	public String getRA_agency_name() {
		return RA_agency_name;
	}

	public void setRA_agency_name(String rA_agency_name) {
		RA_agency_name = rA_agency_name;
	}

	public String getRA_screener() {
		return RA_screener;
	}

	public void setRA_screener(String rA_screener) {
		RA_screener = rA_screener;
	}
	
	
}
