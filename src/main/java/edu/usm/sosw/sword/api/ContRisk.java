package edu.usm.sosw.sword.api;

public class ContRisk {
	private int id;
	private int caseid;
	private String fullname;
	private String dob;
	private int age;
	private String gender;
	private String race;
	private String offense;
	private int offense_class_score;
	private String prior_court;
	private int prior_court_count;
	private int prior_court_score;
	private String past_findings;
	private int past_findings_count;
	private int past_findings_score;
	private String current_case_status;
	private int current_case_status_score;
	private String pending_petitions;
	private int pending_petitions_count;
	private int pending_petitions_score;
	private String under_home_confinement;
	private int under_home_confine_score;
	private String child_RA_age;
	private int child_RA_age_score;
	private String violations_elect_monitoring;
	private int violations_elect_monitoring_score;
	private String risk_FTA_offense;
	private int risk_FTA_reoffense_count;
	private int risk_FTA_reoffense_score;
	private String mitigating_stable_family;
	private String mitigating_stable_school_work;
	private String mitigating_first_offense_16;
	private String mitigating_reg_warrant;
	private int mitigating_reg_warrant_score;
	private String mitigating_reg_warrant_explain;
	private String mitigating_no_arrest;
	private String mitigating_other;
	private int mitigating_other_score;
	private String mitigating_other_explain;
	private int mitigating_total_score;
	private int RA_total_score;
	private String RA_detention_decision;
	private String override_reason;
	private String override_reason_explain;
	private String RA_date;
	private String RA_time;
	private String RA_counselor;
	private String RA_agency_name;
	private String RA_screener;
	
	public ContRisk() {
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

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
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

	public String getOffense() {
		return offense;
	}

	public void setOffense(String offense) {
		this.offense = offense;
	}

	public int getOffense_class_score() {
		return offense_class_score;
	}

	public void setOffense_class_score(int offense_class_score) {
		this.offense_class_score = offense_class_score;
	}

	public String getPrior_court() {
		return prior_court;
	}

	public void setPrior_court(String prior_court) {
		this.prior_court = prior_court;
	}

	public int getPrior_court_count() {
		return prior_court_count;
	}

	public void setPrior_court_count(int prior_court_count) {
		this.prior_court_count = prior_court_count;
	}

	public int getPrior_court_score() {
		return prior_court_score;
	}

	public void setPrior_court_score(int prior_court_score) {
		this.prior_court_score = prior_court_score;
	}

	public String getPast_findings() {
		return past_findings;
	}

	public void setPast_findings(String past_findings) {
		this.past_findings = past_findings;
	}

	public int getPast_findings_count() {
		return past_findings_count;
	}

	public void setPast_findings_count(int past_findings_count) {
		this.past_findings_count = past_findings_count;
	}

	public int getPast_findings_score() {
		return past_findings_score;
	}

	public void setPast_findings_score(int past_findings_score) {
		this.past_findings_score = past_findings_score;
	}

	public String getCurrent_case_status() {
		return current_case_status;
	}

	public void setCurrent_case_status(String current_case_status) {
		this.current_case_status = current_case_status;
	}

	public int getCurrent_case_status_score() {
		return current_case_status_score;
	}

	public void setCurrent_case_status_score(int current_case_status_score) {
		this.current_case_status_score = current_case_status_score;
	}

	public String getPending_petitions() {
		return pending_petitions;
	}

	public void setPending_petitions(String pending_petitions) {
		this.pending_petitions = pending_petitions;
	}

	public int getPending_petitions_count() {
		return pending_petitions_count;
	}

	public void setPending_petitions_count(int pending_petitions_count) {
		this.pending_petitions_count = pending_petitions_count;
	}

	public int getPending_petitions_score() {
		return pending_petitions_score;
	}

	public void setPending_petitions_score(int pending_petitions_score) {
		this.pending_petitions_score = pending_petitions_score;
	}

	public String getUnder_home_confinement() {
		return under_home_confinement;
	}

	public void setUnder_home_confinement(String under_home_confinement) {
		this.under_home_confinement = under_home_confinement;
	}

	public int getUnder_home_confine_score() {
		return under_home_confine_score;
	}

	public void setUnder_home_confine_score(int under_home_confine_score) {
		this.under_home_confine_score = under_home_confine_score;
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

	public String getViolations_elect_monitoring() {
		return violations_elect_monitoring;
	}

	public void setViolations_elect_monitoring(String violations_elect_monitoring) {
		this.violations_elect_monitoring = violations_elect_monitoring;
	}

	public int getViolations_elect_monitoring_score() {
		return violations_elect_monitoring_score;
	}

	public void setViolations_elect_monitoring_score(int violations_elect_monitoring_score) {
		this.violations_elect_monitoring_score = violations_elect_monitoring_score;
	}

	public String getRisk_FTA_offense() {
		return risk_FTA_offense;
	}

	public void setRisk_FTA_offense(String risk_FTA_offense) {
		this.risk_FTA_offense = risk_FTA_offense;
	}

	public int getRisk_FTA_reoffense_count() {
		return risk_FTA_reoffense_count;
	}

	public void setRisk_FTA_reoffense_count(int risk_FTA_reoffense_count) {
		this.risk_FTA_reoffense_count = risk_FTA_reoffense_count;
	}

	public int getRisk_FTA_reoffense_score() {
		return risk_FTA_reoffense_score;
	}

	public void setRisk_FTA_reoffense_score(int risk_FTA_reoffense_score) {
		this.risk_FTA_reoffense_score = risk_FTA_reoffense_score;
	}

	public String getMitigating_stable_family() {
		return mitigating_stable_family;
	}

	public void setMitigating_stable_family(String mitigating_stable_family) {
		this.mitigating_stable_family = mitigating_stable_family;
	}

	public String getMitigating_stable_school_work() {
		return mitigating_stable_school_work;
	}

	public void setMitigating_stable_school_work(String mitigating_stable_school_work) {
		this.mitigating_stable_school_work = mitigating_stable_school_work;
	}

	public String getMitigating_first_offense_16() {
		return mitigating_first_offense_16;
	}

	public void setMitigating_first_offense_16(String mitigating_first_offense_16) {
		this.mitigating_first_offense_16 = mitigating_first_offense_16;
	}

	public String getMitigating_reg_warrant() {
		return mitigating_reg_warrant;
	}

	public void setMitigating_reg_warrant(String mitigating_reg_warrant) {
		this.mitigating_reg_warrant = mitigating_reg_warrant;
	}

	public int getMitigating_reg_warrant_score() {
		return mitigating_reg_warrant_score;
	}

	public void setMitigating_reg_warrant_score(int mitigating_reg_warrant_score) {
		this.mitigating_reg_warrant_score = mitigating_reg_warrant_score;
	}

	public String getMitigating_reg_warrant_explain() {
		return mitigating_reg_warrant_explain;
	}

	public void setMitigating_reg_warrant_explain(String mitigating_reg_warrant_explain) {
		this.mitigating_reg_warrant_explain = mitigating_reg_warrant_explain;
	}

	public String getMitigating_no_arrest() {
		return mitigating_no_arrest;
	}

	public void setMitigating_no_arrest(String mitigating_no_arrest) {
		this.mitigating_no_arrest = mitigating_no_arrest;
	}

	public String getMitigating_other() {
		return mitigating_other;
	}

	public void setMitigating_other(String mitigating_other) {
		this.mitigating_other = mitigating_other;
	}

	public int getMitigating_other_score() {
		return mitigating_other_score;
	}

	public void setMitigating_other_score(int mitigating_other_score) {
		this.mitigating_other_score = mitigating_other_score;
	}

	public String getMitigating_other_explain() {
		return mitigating_other_explain;
	}

	public void setMitigating_other_explain(String mitigating_other_explain) {
		this.mitigating_other_explain = mitigating_other_explain;
	}

	public int getMitigating_total_score() {
		return mitigating_total_score;
	}

	public void setMitigating_total_score(int mitigating_total_score) {
		this.mitigating_total_score = mitigating_total_score;
	}

	public int getRA_total_score() {
		return RA_total_score;
	}

	public void setRA_total_score(int rA_total_score) {
		RA_total_score = rA_total_score;
	}

	public String getRA_detention_decision() {
		return RA_detention_decision;
	}

	public void setRA_detention_decision(String rA_detention_decision) {
		RA_detention_decision = rA_detention_decision;
	}

	public String getOverride_reason() {
		return override_reason;
	}

	public void setOverride_reason(String override_reason) {
		this.override_reason = override_reason;
	}

	public String getOverride_reason_explain() {
		return override_reason_explain;
	}

	public void setOverride_reason_explain(String override_reason_explain) {
		this.override_reason_explain = override_reason_explain;
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

	public String getRA_counselor() {
		return RA_counselor;
	}

	public void setRA_counselor(String rA_counselor) {
		RA_counselor = rA_counselor;
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
