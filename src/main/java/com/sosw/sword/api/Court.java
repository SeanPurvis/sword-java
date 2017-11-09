package com.sosw.sword.api;

import java.sql.Date;

public class Court {
	private int id;
	private int caseid;
	private String attorney_childs;
	private Date attorney_childs_appointed_date;
	private String attorney_fathers;
	private String attorney_mothers;
	private Date case_appointed_date;
	private String court_summary;
	private String court_type;
	private Date formal_petition_filed_date;
	private Date formal_petition_ordered_date;
	private int formal_petition_code;
	private Date gal_appointed_date;
	private String gal_bar_number;
	private Date hearing_date;
	private String hearing_type;
	private Date informal_adjustment_ordered_date;
	private String judge;
	private String mdhs_name;
	private String mdhs_reccomendation;
	private Date motion_entered_date;
	private Date next_hearing_date;
	private String no_show;
	private int number_of_continuances_granted;
	private String plan_concurrent;
	private String plan_permanent;
	private String subpoenaed_names;
	private Date summons_issued_on_child_date;
	private Date summons_served_on_child_date;
	private Date take_no_action_ordered_date;
	private String waived;
	private String witnesses;
	private String zero_to_three_program;
	
	public Court() {
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

	public String getAttorney_childs() {
		return attorney_childs;
	}

	public void setAttorney_childs(String attorney_childs) {
		this.attorney_childs = attorney_childs;
	}

	public Date getAttorney_childs_appointed_date() {
		return attorney_childs_appointed_date;
	}

	public void setAttorney_childs_appointed_date(Date attorney_childs_appointed_date) {
		this.attorney_childs_appointed_date = attorney_childs_appointed_date;
	}

	public String getAttorney_fathers() {
		return attorney_fathers;
	}

	public void setAttorney_fathers(String attorney_fathers) {
		this.attorney_fathers = attorney_fathers;
	}

	public String getAttorney_mothers() {
		return attorney_mothers;
	}

	public void setAttorney_mothers(String attorney_mothers) {
		this.attorney_mothers = attorney_mothers;
	}

	public Date getCase_appointed_date() {
		return case_appointed_date;
	}

	public void setCase_appointed_date(Date case_appointed_date) {
		this.case_appointed_date = case_appointed_date;
	}

	public String getCourt_summary() {
		return court_summary;
	}

	public void setCourt_summary(String court_summary) {
		this.court_summary = court_summary;
	}

	public String getCourt_type() {
		return court_type;
	}

	public void setCourt_type(String court_type) {
		this.court_type = court_type;
	}

	public Date getFormal_petition_filed_date() {
		return formal_petition_filed_date;
	}

	public void setFormal_petition_filed_date(Date formal_petition_filed_date) {
		this.formal_petition_filed_date = formal_petition_filed_date;
	}

	public Date getFormal_petition_ordered_date() {
		return formal_petition_ordered_date;
	}

	public void setFormal_petition_ordered_date(Date formal_petition_ordered_date) {
		this.formal_petition_ordered_date = formal_petition_ordered_date;
	}

	public int getFormal_petition_code() {
		return formal_petition_code;
	}

	public void setFormal_petition_code(int formal_petition_code) {
		this.formal_petition_code = formal_petition_code;
	}

	public Date getGal_appointed_date() {
		return gal_appointed_date;
	}

	public void setGal_appointed_date(Date gal_appointed_date) {
		this.gal_appointed_date = gal_appointed_date;
	}

	public String getGal_bar_number() {
		return gal_bar_number;
	}

	public void setGal_bar_number(String gal_bar_number) {
		this.gal_bar_number = gal_bar_number;
	}

	public Date getHearing_date() {
		return hearing_date;
	}

	public void setHearing_date(Date hearing_date) {
		this.hearing_date = hearing_date;
	}

	public String getHearing_type() {
		return hearing_type;
	}

	public void setHearing_type(String hearing_type) {
		this.hearing_type = hearing_type;
	}

	public Date getInformal_adjustment_ordered_date() {
		return informal_adjustment_ordered_date;
	}

	public void setInformal_adjustment_ordered_date(Date informal_adjustment_ordered_date) {
		this.informal_adjustment_ordered_date = informal_adjustment_ordered_date;
	}

	public String getJudge() {
		return judge;
	}

	public void setJudge(String judge) {
		this.judge = judge;
	}

	public String getMdhs_name() {
		return mdhs_name;
	}

	public void setMdhs_name(String mdhs_name) {
		this.mdhs_name = mdhs_name;
	}

	public String getMdhs_reccomendation() {
		return mdhs_reccomendation;
	}

	public void setMdhs_reccomendation(String mdhs_reccomendation) {
		this.mdhs_reccomendation = mdhs_reccomendation;
	}

	public Date getMotion_entered_date() {
		return motion_entered_date;
	}

	public void setMotion_entered_date(Date motion_entered_date) {
		this.motion_entered_date = motion_entered_date;
	}

	public Date getNext_hearing_date() {
		return next_hearing_date;
	}

	public void setNext_hearing_date(Date next_hearing_date) {
		this.next_hearing_date = next_hearing_date;
	}

	public String getNo_show() {
		return no_show;
	}

	public void setNo_show(String no_show) {
		this.no_show = no_show;
	}

	public int getNumber_of_continuances_granted() {
		return number_of_continuances_granted;
	}

	public void setNumber_of_continuances_granted(int number_of_continuances_granted) {
		this.number_of_continuances_granted = number_of_continuances_granted;
	}

	public String getPlan_concurrent() {
		return plan_concurrent;
	}

	public void setPlan_concurrent(String plan_concurrent) {
		this.plan_concurrent = plan_concurrent;
	}

	public String getPlan_permanent() {
		return plan_permanent;
	}

	public void setPlan_permanent(String plan_permanent) {
		this.plan_permanent = plan_permanent;
	}

	public String getSubpoenaed_names() {
		return subpoenaed_names;
	}

	public void setSubpoenaed_names(String subpoenaed_names) {
		this.subpoenaed_names = subpoenaed_names;
	}

	public Date getSummons_issued_on_child_date() {
		return summons_issued_on_child_date;
	}

	public void setSummons_issued_on_child_date(Date summons_issued_on_child_date) {
		this.summons_issued_on_child_date = summons_issued_on_child_date;
	}

	public Date getSummons_served_on_child_date() {
		return summons_served_on_child_date;
	}

	public void setSummons_served_on_child_date(Date summons_served_on_child_date) {
		this.summons_served_on_child_date = summons_served_on_child_date;
	}

	public Date getTake_no_action_ordered_date() {
		return take_no_action_ordered_date;
	}

	public void setTake_no_action_ordered_date(Date take_no_action_ordered_date) {
		this.take_no_action_ordered_date = take_no_action_ordered_date;
	}

	public String getWaived() {
		return waived;
	}

	public void setWaived(String waived) {
		this.waived = waived;
	}

	public String getWitnesses() {
		return witnesses;
	}

	public void setWitnesses(String witnesses) {
		this.witnesses = witnesses;
	}

	public String getZero_to_three_program() {
		return zero_to_three_program;
	}

	public void setZero_to_three_program(String zero_to_three_program) {
		this.zero_to_three_program = zero_to_three_program;
	}
	
	
}
