package edu.usm.sosw.sword.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import edu.usm.sosw.sword.api.Action;
import edu.usm.sosw.sword.db.ActionDAO;


/**
 * This ActionMapper maps SQL query results to an Action object.
 * 
 * @author Jonathon Evans
 * @version 0.0.1 
 * @type Action Object
 * @return a new <code>Action</code> object with SQL Query results populated into the data members.
 * @see Action 
 * @see ActionDAO
 */

public class ActionMapper implements ResultSetMapper<Action>{
	public Action map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new Action(
				r.getInt("caseid"),
				r.getInt("courtid"),
				r.getInt("id"),
				r.getDate("date_of_action"),
				r.getString("action_type"),
				r.getString("current_risk_level"),
				r.getString("abused"),
				r.getString("adoslescent_offender_program"),
				r.getString("adjudicated"),
				r.getString("certified"),
				r.getString("child_in_need_special_care"),
				r.getString("chins"),
				r.getString("community_care"),
				r.getString("community_service"),
				r.getString("hours"),
				r.getString("counselor_supervision"),
				r.getString("dys"),
				r.getString("delinquent"),
				r.getString("dependent"),
				r.getString("detention"),
				r.getString("dismissed"),
				r.getString("drug_court"),
				r.getString("electronic_monitor"),
				r.getString("fined"),
				r.getString("fine_amount"),
				r.getString("held_open"),
				r.getString("intensive_supervision"),
				r.getString("legal_custody_change"),
				r.getString("lcc_dhs"),
				r.getString("lcc_relative_or_other"),
				r.getString("mycc"),
				r.getString("neglected"),
				r.getString("not_adjudicated"),
				r.getString("other"),
				r.getString("other2"),
				r.getString("physical_custody_change"),
				r.getString("pcc_dhs"),
				r.getString("pcc_relative_or_other"),
				r.getString("probation"),
				r.getInt("prob_months_amt"),
				r.getString("prob_extended"),
				r.getDate("supervision_period_form"),
				r.getDate("supervision_period_to"),
				r.getString("restitution"),
				r.getString("restitution_amount"),
				r.getString("returned_home"),
				r.getString("runaway"),
				r.getString("runaway_returned"),
				r.getString("status_offense"),
				r.getString("suspended_commitment"),
				r.getString("suspended_license"),
				r.getString("transferred"),
				r.getDate("date_transported"),
				r.getString("truant"),
				r.getString("unsupervised_prob"),
				r.getString("warned_adjusted_counseled"),
				r.getString("action_note"));
	}
}
