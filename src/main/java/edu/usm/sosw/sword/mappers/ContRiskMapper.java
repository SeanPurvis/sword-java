package edu.usm.sosw.sword.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import edu.usm.sosw.sword.api.ContRisk;

/**
 * This ContRiskMapper maps SQL query results to an ContRisk object.
 * 
 * @author Jonathon Evans
 * @version 0.0.1 
 * @type ContRisk Object
 * @return a new <code>ContRisk</code> object with SQL Query results populated into the data members.
 * @see ContRisk 
 * @see ContRiskDAO
 */
public class ContRiskMapper implements ResultSetMapper<ContRisk>{
	public ContRisk map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new ContRisk(
				r.getInt("id"),
				r.getInt("caseid"),
				r.getString("fullname"),
				r.getString("dob"),
				r.getInt("age"),
				r.getString("gender"),
				r.getString("race"),
				r.getString("offense"),
				r.getInt("offense_class_score"),
				r.getString("prior_court"),
				r.getInt("prior_court_count"),
				r.getInt("prior_court_score"),
				r.getString("past_findings"),
				r.getInt("past_findings_count"),
				r.getInt("past_findings_score"),
				r.getString("current_case_status"),
				r.getInt("current_case_status_score"),
				r.getString("pending_petitions"),
				r.getInt("pending_petitions_count"),
				r.getInt("pending_petitions_score"),
				r.getString("under_home_confinement"),
				r.getInt("under_home_confine_score"),
				r.getString("child_RA_age"),
				r.getInt("child_RA_age_score"),
				r.getString("violations_elect_monitoring"),
				r.getInt("violations_elect_monitoring_score"),
				r.getString("risk_FTA_reoffense"),
				r.getInt("risk_FTA_reoffense_count"),
				r.getInt("risk_FTA_reoffense_score"),
				r.getString("mitigating_stable_family"),
				r.getString("mitigating_stable_school_work"),
				r.getString("mitigating_first_offense_16"),
				r.getString("mitigating_reg_warrant"),
				r.getInt("mitigating_reg_warrant_score"),
				r.getString("mitigating_reg_warrant_explain"),
				r.getString("mitigating_no_arrest"),
				r.getString("mitigating_other"),
				r.getInt("mitigating_other_score"),
				r.getString("mitigating_other_explain"),
				r.getInt("mitigating_total_score"),
				r.getInt("RA_total_score"),
				r.getString("RA_detention_decision"),
				r.getString("override_reason"),
				r.getString("override_reason_explain"),
				r.getString("RA_date"),
				r.getString("RA_time"),
				r.getString("RA_counselor"),
				r.getString("RA_agency_name"),
				r.getString("RA_screener"));
	}
}