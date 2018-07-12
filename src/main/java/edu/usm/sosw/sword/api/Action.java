package edu.usm.sosw.sword.api;

import java.sql.Date;

public class Action {
	private int caseid;
	private int courtid;
	private int id;
	private Date date_of_action;
	private String action_type;
	private String current_risk_level;
	private String abused;
	private String adolescent_offender_program;
	private String adjudicated;
	private String certified;
	private String child_in_need_special_care;
	private String chins;
	private String community_care;
	private String community_service;
	private String hours;
	private String counselor_supervision;
	private String dys;
	private String delinquent;
	private String dependent;
	private String detention;
	private String dismissed;
	private String drug_court;
	private String electronic_monitor;
	private String fined;
	private String fine_amount;
	private String held_open;
	private String intensive_supervision;
	private String legal_custody_change;
	private String lcc_dhs;
	private String lcc_relative_or_other;
	private String mycc;
	private String neglected;
	private String not_adjudicated;
	private String other;
	private String other2;
	private String physical_custody_change;
	private String pcc_dhs;
	private String pcc_relative_or_other;
	private String probation;
	private int prob_months_amt;
	private String prob_extended;
	private Date supervision_period_from;
	private Date supervision_period_to;
	private String restitution;
	private String restitution_amount;
	private String returned_home;
	private String runaway;
	private String runaway_returned;
	private String status_offense;
	private String suspended_commitment;
	private String suspended_license;
	private String transferred;
	private Date date_transported;
	private String truant;
	private String unsupervised_prob;
	private String warned_adjusted_counseled;
	private String action_note;
	
	public Action() {
		//Needed for Jackson deserialization
	}
	public Action(
			int caseid, 
			int courtid, 
			int id, 
			Date date_of_action, 
			String action_type, 
			String current_risk_level,
			String abused,
			String adolescent_offender_program,
			String adjudicated,
			String certified,
			String child_in_need_special_care,
			String chins,
			String community_care,
			String community_service,
			String hours,
			String counselor_supervision,
			String dys,
			String delinquent,
			String dependent,
			String detention,
			String dismissed,
			String drug_court,
			String electronic_monitor,
			String fined,
			String fine_amount,
			String held_open,
			String intensive_supervision,
			String legal_custody_change,
			String lcc_dhs,
			String lcc_relative_or_other,
			String mycc,
			String neglected,
			String not_adjudicated,
			String other,
			String other2,
			String physical_custody_change,
			String pcc_dhs,
			String pcc_relative_or_other,
			String probation,
			int prob_months_amt,
			String prob_extended,
			Date supervision_period_from,
			Date supervision_period_to,
			String restitution,
			String restitution_amount,
			String returned_home,
			String runaway,
			String runaway_returned,
			String status_offense,
			String suspended_commitment,
			String suspended_license,
			String transferred,
			Date date_transported,
			String truant,
			String unsupervised_prob,
			String warned_adjusted_counseled,
			String action_note) {
		super();
		this.caseid = caseid;
		this.courtid = courtid;
		this.id = id;
		this.date_of_action = date_of_action;
		this.action_type = action_type;
		this.current_risk_level = current_risk_level;
		this.abused = abused;
		this.adolescent_offender_program = adolescent_offender_program;
		this.adjudicated = adjudicated;
		this.certified = certified;
		this.child_in_need_special_care = child_in_need_special_care;
		this.chins = chins;
		this.community_care = community_care;
		this.community_service = community_service;
		this.hours = hours;
		this.counselor_supervision = counselor_supervision;
		this.dys = dys;
		this.delinquent = delinquent;
		this.dependent = dependent;
		this.detention = detention;
		this.dismissed = dismissed;
		this.drug_court = drug_court;
		this.electronic_monitor = electronic_monitor;
		this.fined = fined;
		this.fine_amount = fine_amount;
		this.held_open = held_open;
		this.intensive_supervision = intensive_supervision;
		this.legal_custody_change = legal_custody_change;
		this.lcc_dhs = lcc_dhs;
		this.lcc_relative_or_other = lcc_relative_or_other;
		this.mycc = mycc;
		this.neglected = neglected;
		this.not_adjudicated = not_adjudicated;
		this.other = other;
		this.other2 = other2;
		this.physical_custody_change = physical_custody_change;
		this.pcc_dhs = pcc_dhs;
		this.pcc_relative_or_other = pcc_relative_or_other;
		this.probation = probation;
		this.prob_months_amt = prob_months_amt;
		this.prob_extended = prob_extended;
		this.supervision_period_from = supervision_period_from;
		this.supervision_period_to = supervision_period_to;
		this.restitution = restitution;
		this.restitution_amount = restitution_amount;
		this.returned_home = returned_home;
		this.status_offense = status_offense;
		this.suspended_commitment = suspended_commitment;
		this.suspended_license = suspended_license;
		this.transferred = transferred;
		this.date_transported = date_transported;
		this.truant = truant;
		this.unsupervised_prob = unsupervised_prob;
		this.warned_adjusted_counseled = warned_adjusted_counseled;
		this.action_note = action_note;
	}

	public int getCaseid() {
		return caseid;
	}

	public void setCaseid(int caseid) {
		this.caseid = caseid;
	}

	public int getCourtid() {
		return courtid;
	}

	public void setCourtid(int courtid) {
		this.courtid = courtid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate_of_action() {
		return date_of_action;
	}

	public void setDate_of_action(Date date_of_action) {
		this.date_of_action = date_of_action;
	}

	public String getAction_type() {
		return action_type;
	}

	public void setAction_type(String action_type) {
		this.action_type = action_type;
	}

	public String getCurrent_risk_level() {
		return current_risk_level;
	}

	public void setCurrent_risk_level(String current_risk_level) {
		this.current_risk_level = current_risk_level;
	}

	public String getAbused() {
		return abused;
	}

	public void setAbused(String abused) {
		this.abused = abused;
	}

	public String getAdolescent_offender_program() {
		return adolescent_offender_program;
	}

	public void setAdolescent_offender_program(String adoslescent_offender_program) {
		this.adolescent_offender_program = adoslescent_offender_program;
	}

	public String getAdjudicated() {
		return adjudicated;
	}

	public void setAdjudicated(String adjudicated) {
		this.adjudicated = adjudicated;
	}

	public String getCertified() {
		return certified;
	}

	public void setCertified(String certified) {
		this.certified = certified;
	}

	public String getChild_in_need_special_care() {
		return child_in_need_special_care;
	}

	public void setChild_in_need_special_care(String child_in_need_special_care) {
		this.child_in_need_special_care = child_in_need_special_care;
	}

	public String getChins() {
		return chins;
	}

	public void setChins(String chins) {
		this.chins = chins;
	}

	public String getCommunity_care() {
		return community_care;
	}

	public void setCommunity_care(String community_care) {
		this.community_care = community_care;
	}

	public String getCommunity_service() {
		return community_service;
	}

	public void setCommunity_service(String community_service) {
		this.community_service = community_service;
	}

	public String getHours() {
		return hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}

	public String getCounselor_supervision() {
		return counselor_supervision;
	}

	public void setCounselor_supervision(String counselor_supervision) {
		this.counselor_supervision = counselor_supervision;
	}

	public String getDys() {
		return dys;
	}

	public void setDys(String dys) {
		this.dys = dys;
	}

	public String getDelinquent() {
		return delinquent;
	}

	public void setDelinquent(String delinquent) {
		this.delinquent = delinquent;
	}

	public String getDependent() {
		return dependent;
	}

	public void setDependent(String dependent) {
		this.dependent = dependent;
	}

	public String getDetention() {
		return detention;
	}

	public void setDetention(String detention) {
		this.detention = detention;
	}

	public String getDismissed() {
		return dismissed;
	}

	public void setDismissed(String dismissed) {
		this.dismissed = dismissed;
	}

	public String getDrug_court() {
		return drug_court;
	}

	public void setDrug_court(String drug_court) {
		this.drug_court = drug_court;
	}

	public String getElectronic_monitor() {
		return electronic_monitor;
	}

	public void setElectronic_monitor(String electronic_monitor) {
		this.electronic_monitor = electronic_monitor;
	}

	public String getFined() {
		return fined;
	}

	public void setFined(String fined) {
		this.fined = fined;
	}

	public String getFine_amount() {
		return fine_amount;
	}

	public void setFine_amount(String fine_amount) {
		this.fine_amount = fine_amount;
	}

	public String getHeld_open() {
		return held_open;
	}

	public void setHeld_open(String held_open) {
		this.held_open = held_open;
	}

	public String getIntensive_supervision() {
		return intensive_supervision;
	}

	public void setIntensive_supervision(String intensive_supervision) {
		this.intensive_supervision = intensive_supervision;
	}

	public String getLegal_custody_change() {
		return legal_custody_change;
	}

	public void setLegal_custody_change(String legal_custody_change) {
		this.legal_custody_change = legal_custody_change;
	}

	public String getLcc_dhs() {
		return lcc_dhs;
	}

	public void setLcc_dhs(String lcc_dhs) {
		this.lcc_dhs = lcc_dhs;
	}

	public String getLcc_relative_or_other() {
		return lcc_relative_or_other;
	}

	public void setLcc_relative_or_other(String lcc_relative_or_other) {
		this.lcc_relative_or_other = lcc_relative_or_other;
	}

	public String getMycc() {
		return mycc;
	}

	public void setMycc(String mycc) {
		this.mycc = mycc;
	}

	public String getNeglected() {
		return neglected;
	}

	public void setNeglected(String neglected) {
		this.neglected = neglected;
	}

	public String getNot_adjudicated() {
		return not_adjudicated;
	}

	public void setNot_adjudicated(String not_adjudicated) {
		this.not_adjudicated = not_adjudicated;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getOther2() {
		return other2;
	}

	public void setOther2(String other2) {
		this.other2 = other2;
	}

	public String getPhysical_custody_change() {
		return physical_custody_change;
	}

	public void setPhysical_custody_change(String physical_custody_change) {
		this.physical_custody_change = physical_custody_change;
	}

	public String getPcc_dhs() {
		return pcc_dhs;
	}

	public void setPcc_dhs(String pcc_dhs) {
		this.pcc_dhs = pcc_dhs;
	}

	public String getPcc_relative_or_other() {
		return pcc_relative_or_other;
	}

	public void setPcc_relative_or_other(String pcc_relative_or_other) {
		this.pcc_relative_or_other = pcc_relative_or_other;
	}

	public String getProbation() {
		return probation;
	}

	public void setProbation(String probation) {
		this.probation = probation;
	}

	public int getProb_months_amt() {
		return prob_months_amt;
	}

	public void setProb_months_amt(int prob_months_amt) {
		this.prob_months_amt = prob_months_amt;
	}

	public String getProb_extended() {
		return prob_extended;
	}

	public void setProb_extended(String prob_extended) {
		this.prob_extended = prob_extended;
	}

	public Date getSupervision_period_from() {
		return supervision_period_from;
	}

	public void setSupervision_period_from(Date supervision_period_from) {
		this.supervision_period_from = supervision_period_from;
	}

	public Date getSupervision_period_to() {
		return supervision_period_to;
	}

	public void setSupervision_period_to(Date supervision_period_to) {
		this.supervision_period_to = supervision_period_to;
	}

	public String getRestitution() {
		return restitution;
	}

	public void setRestitution(String restitution) {
		this.restitution = restitution;
	}

	public String getRestitution_amount() {
		return restitution_amount;
	}

	public void setRestitution_amount(String restitution_amount) {
		this.restitution_amount = restitution_amount;
	}

	public String getReturned_home() {
		return returned_home;
	}

	public void setReturned_home(String returned_home) {
		this.returned_home = returned_home;
	}

	public String getRunaway() {
		return runaway;
	}

	public void setRunaway(String runaway) {
		this.runaway = runaway;
	}

	public String getRunaway_returned() {
		return runaway_returned;
	}

	public void setRunaway_returned(String runaway_returned) {
		this.runaway_returned = runaway_returned;
	}

	public String getStatus_offense() {
		return status_offense;
	}

	public void setStatus_offense(String status_offense) {
		this.status_offense = status_offense;
	}

	public String getSuspended_commitment() {
		return suspended_commitment;
	}

	public void setSuspended_commitment(String suspended_commitment) {
		this.suspended_commitment = suspended_commitment;
	}

	public String getSuspended_license() {
		return suspended_license;
	}

	public void setSuspended_liscense(String suspended_license) {
		this.suspended_license = suspended_license;
	}

	public String getTransferred() {
		return transferred;
	}

	public void setTransferred(String transferred) {
		this.transferred = transferred;
	}

	public Date getDate_transported() {
		return date_transported;
	}

	public void setDate_transported(Date date_transported) {
		this.date_transported = date_transported;
	}

	public String getTruant() {
		return truant;
	}

	public void setTruant(String truant) {
		this.truant = truant;
	}

	public String getUnsupervised_prob() {
		return unsupervised_prob;
	}

	public void setUnsupervised_prob(String unsupervised_prob) {
		this.unsupervised_prob = unsupervised_prob;
	}

	public String getWarned_adjusted_counseled() {
		return warned_adjusted_counseled;
	}

	public void setWarned_adjusted_counseled(String warned_adjusted_counseled) {
		this.warned_adjusted_counseled = warned_adjusted_counseled;
	}

	public String getAction_note() {
		return action_note;
	}

	public void setAction_note(String action_note) {
		this.action_note = action_note;
	}
}
